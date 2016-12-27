package ru.test.yandex;

import com.objsys.asn1j.runtime.Asn1Exception;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import ru.test.api.Externalsystems.HTTPSExternalSystem;
import ru.test.api.Helpers.CMSHelper;
import ru.test.api.Helpers.StringHelper;
import ru.test.api.Helpers.XMLHelper;
import ru.test.api.exceptions.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.UnsupportedCharsetException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by Дмитрий Астахов on 26.12.2016.
 */
public class YandexId extends HTTPSExternalSystem {

    public YandexId() {
        super("url=https://calypso.yamoney.ru:9094/webservice/deposition/api/testDeposition;keystoretype=pkcs12;keystore=C:\\CryptoPro\\Client Certificates\\dd_yandex.p12;keystorepassword=123456;agentid=201326",
                "PKIX", "TLSv1.2");
    }
    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    protected HttpEntity getHttpEntity(List<NameValuePair> requestParams) throws ExternalSystemException {
        StringEntity entityXML = null;

        try {
            entityXML = new StringEntity(requestParams.get(0).getValue(), "UTF-8");
            entityXML.setContentType("application/pkcs7-mime");
        } catch (UnsupportedCharsetException e) {
            throw new ExternalSystemException("(Яндекс Deposite)Ошибка формирования запроса к сервису Яндекс", e);
        }

        return entityXML;
    }

    public String main(String input) throws ExternalSystemException, ExternalSystemIOException, ExternalSystemArgumentException, AxiLinkException, ExternalSystemCryptoException {
        Map<String, String> inputParams = null;
        try {
            inputParams = StringHelper.splitParamsStringToMap(input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String phoneNumber = inputParams.get("phone");
        String agentId = this.getConnectionParams().get("agentid");
        String certName = this.getConnectionParams().get("keystore");
        String certPassword = this.getConnectionParams().get("keystorepassword");
        String keyStoreType = this.getConnectionParams().get("keystoretype");
        String keyStoreCertName = null;
        int clientOrderId = randInt();
        String result = null;

        String dateTime = null;
        try {
            dateTime = getXMLGregorianCalendar();
        } catch (DatatypeConfigurationException | ParseException e) {
            throw new ExternalSystemIOException("(Яндекс Deposite)Ошибка формирования даты", e);
        }

        log.info("(Яндекс Deposite)Формирование запроса с clientOrderId = " + clientOrderId);

        String inputXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<testDepositionRequest agentId=\"" + agentId + "\"\n" +
                "                       clientOrderId=\"" + clientOrderId + "\" \n" +
                "                       requestDT=\"" + dateTime + "\"\n" +
                "                       dstAccount=\"" + phoneNumber + "\"\n" +
                "                       amount=\"10.00\"\n" +
                "                       currency=\"643\"\n" +
                "                       contract=\"\"/>";

        KeyStore keyStore = null;
        try {
            keyStore = KeyStore.getInstance(keyStoreType);
            keyStore.load(new FileInputStream(certName), certPassword.toCharArray());
            keyStoreCertName = keyStore.aliases().nextElement();
        } catch (KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException e) {
            throw new ExternalSystemIOException("(Яндекс Deposite)Ошибка инициализации криптографической подсистемы", e);
        }

        byte[] cms = null;
        String cmsRequest = null;
        try {
            cmsRequest = CMSHelper.signPEM(inputXML.getBytes(), (PrivateKey) keyStore.getKey(keyStoreCertName, certPassword.toCharArray()), (X509Certificate)keyStore.getCertificate(keyStoreCertName));
        } catch (KeyStoreException | UnrecoverableKeyException | NoSuchAlgorithmException | IOException | InvalidKeyException | SignatureException e) {
            throw new ExternalSystemIOException("(Яндекс Deposite)Ошибка шифрования запроса к сервису Яндекс", e);
        }

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("cms", cmsRequest));

        try {
            result = requestApi(params);
        } catch (IOException e) {
            throw new ExternalSystemIOException("(Яндекс Deposite)Сетевая ошибка отправки запроса к сервису Яндекс", e);
        }

        String responseString = result;
        responseString = responseString.replaceAll("-----BEGIN PKCS7-----\\n", "");
        responseString = responseString.replaceAll("\\n-----END PKCS7-----", "");

        byte[] resultBytes = Base64.decode(responseString);
        try {
            cms = CMSHelper.unsignPKCS7(resultBytes);
        } catch (NullPointerException | Asn1Exception | IOException e) {
            throw new ExternalSystemException("(Яндекс Deposite)Ошибка дешифрования ответа от сервиса Яндекс:" + e.getMessage(), e);
        }

        try {
            result = new String(cms, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new ExternalSystemException("(Яндекс Deposite)Ошибка декодирования(неверная кодировка) ответа от сервиса Яндекс", e);
        }

        Document doc = null;
        try {
            doc = XMLHelper.parseXml(result);
        } catch (IOException | SAXException | ParserConfigurationException e) {
            throw new ExternalSystemException("(Яндекс Deposite)Ошибка разбора ответа от сервиса Яндекс", e);
        }

        Node errorElem = doc.getElementsByTagName("testDepositionResponse").item(0);
        String status = errorElem.getAttributes().getNamedItem("status").getNodeValue();
        if (!"0".equals(status)){
            String errorMessage = null;
            try {
                errorMessage = new String(XMLHelper.evaluateXPath(doc, "/testDepositionResponse/@error").getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new ExternalSystemException("(Яндекс Deposite)Ошибка ответа от сервиса Яндекс: status=" + status, e);
            }

            throw new ExternalSystemException("(Яндекс Deposite)Ошибка ответа от сервиса Яндекс: error=" + errorMessage + " status=" + status);
        }
        log.info(dateTime);
        return result;
    }

    public static int randInt() {
        Random rand = new Random();
        int randomNum = rand.nextInt();

        return randomNum < 0 ? -randomNum: randomNum;
    }

    public String getXMLGregorianCalendar() throws DatatypeConfigurationException, ParseException, ExternalSystemException {
        GregorianCalendar calendar = new GregorianCalendar();
        return  DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar).toString();
    }
}
