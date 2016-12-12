package ru.test.yandex;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import ru.test.api.Externalsystems.HTTPSExternalSystem;
import ru.test.api.Helpers.HashHelper;
import ru.test.api.Helpers.StringHelper;
import ru.test.api.Helpers.XMLHelper;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ������� ������� on 18.11.2016.
 */
public class YandexFio extends HTTPSExternalSystem{
    YandexFio() {
        super(null);
    }

    @Override
    protected String getUrl() {
//        return "http://requestb.in/1j4tvas1";
        return "https://calypso.yamoney.ru:443/";
//        return "https://calypso.yamoney.ru:9094/webservice/iddata/api/idDataCheck";
//        return "https://bo-demo02.yamoney.ru:9094/webservice/iddata/api/idDataCheck";
    }

    @Override
    protected HttpEntity getHttpEntity(List<NameValuePair> requestParams) throws Exception {
//        StringEntity entityXML = null;
//        entityXML = new StringEntity(requestParams.get(0).getValue(), "windows-1251");
//        entityXML.setContentType("text/xml");
//
//        return entityXML;

        UrlEncodedFormEntity requestEntitty = null;

        try {
            requestEntitty = new UrlEncodedFormEntity(requestParams, "Windows-1251");
        } catch (UnsupportedEncodingException e) {
            throw new Exception("(Яндекс Deposite)Ошибка формирования параметров запроса");
        }

        return requestEntitty;
    }

    @Override
    public void setHeaders(HttpPost httpPost) {
//        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
    }


    public String main(String input) throws Exception {
        Map<String, String> inputParams = StringHelper.splitParamsStringToMap(input);

        String name = inputParams.get("name");
        String lastname = inputParams.get("surname");
        String patronomyc = inputParams.get("middlename");
        String seriaNumber = inputParams.get("seriaNumber");
        String walletNumber = inputParams.get("wallet");
        String fioNumber = null;

        name = StringHelper.transliterateYandex(StringHelper.replaceYoToYe(name.toUpperCase()));
        lastname = StringHelper.transliterateYandex(StringHelper.replaceYoToYe(lastname.toUpperCase()));
        patronomyc = StringHelper.transliterateYandex(StringHelper.replaceYoToYe(patronomyc.toUpperCase()));

        fioNumber = lastname + "_" + name + "_" + patronomyc + "_" + seriaNumber;
        fioNumber = "XANNANOV_VLADISLAV_ANATOL`EVICH_" + seriaNumber;

        System.out.println("############### REQUEST #####################");
        System.out.println("fioNumber = " + fioNumber);
        try {
            byte[] hashSHA1 = HashHelper.getSHA1Hash(fioNumber.getBytes("Windows-1251"));
            fioNumber = Base64.encodeBase64String(hashSHA1);
//            fioNumber = StringHelper.toHexString(hashSHA1);
//            fioNumber = Base64.encodeBase64String(fioNumber.getBytes());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            throw new Exception("(Яндекс ID)Ошибка хеширования запроса", e);
        }
////
//        String inputXML = "<?xml version=\"1.0\" encoding=\"windows-1251\"?>\n" +
//                "<REQUEST>\n" +
//                "    <ACT_ID>idDataCheck</ACT_ID>\\n\" +\n" +
//                "                \"    <VERSION>2.50</VERSION>\\n\" +\n" +
//                "                \"    <DSTACNT_NR>" + walletNumber + "</DSTACNT_NR>\\n\" +\n" +
//                "                \"    <ID_DATA>\\n\" +\n" +
//                "                \"        <IDDOC_HASH>" + fioNumber + "</IDDOC_HASH>\\n\" +\n" +
//                "                \"    </ID_DAT>\n" +
//                "</REQUEST>";
//
//        List<NameValuePair> requestParams = new ArrayList<NameValuePair>();
//        requestParams.add(new BasicNameValuePair("xml", inputXML));
//        fioNumber = "jg56hf84";
//        walletNumber = "4100375017397";
        String ID_DATA = "<?xml version=\"1.0\" encoding=\"windows-1251\"?>" +
                "<ID_DATA>" +
                "<IDDOC_HASH>" + fioNumber + "</IDDOC_HASH>" +
                "</ID_DATA>";

        List<NameValuePair> requestParams = new ArrayList<NameValuePair>();
        requestParams.add(new BasicNameValuePair("ACT_ID", "idDataCheck"));
        requestParams.add(new BasicNameValuePair("VERSION", "2.50"));
        requestParams.add(new BasicNameValuePair("DSTACNT_NR", walletNumber));
        requestParams.add(new BasicNameValuePair("ID_DATA", ID_DATA));

        System.out.println("DSTACNT_NR = " + walletNumber);
        System.out.println("ID_DATA = " + ID_DATA);

        System.out.println("\n####################################");

        setConnectionSetting(TMFEnum.PKIX, SSLCEnum.TLSv1_2);
        String result = null;
        try {
            result = requestApi(requestParams);
        } catch (IOException e) {
            throw new Exception("(Яндекс ID)Ошибка отправки запроса", e);
        }

        return result;

//        Document doc = null;
//        try {
//            doc = XMLHelper.parseXml(result, "Windows-1251");
//        } catch (IOException | SAXException | ParserConfigurationException e) {
//            throw new Exception("(������ ID)������ ������� ������ �� ������� ������", e);
//        }
//
//        Node errorElem = doc.getElementsByTagName("response").item(0);
//        String responseCode = errorElem.getAttributes().getNamedItem("code").getNodeValue();
//        if (!"0".equals(responseCode)) {
//            String errorMessage = null;
//            String errorTechMessage = null;
//            String errorCode = null;
//
//            try {
//                errorMessage = new String(XMLHelper.evaluateXPath(doc, "/response/error/message").getBytes("Cp1251"));
//                errorTechMessage = new String(XMLHelper.evaluateXPath(doc, "/response/error/tech-message").getBytes("Cp1251"));
//                errorCode = XMLHelper.evaluateXPath(doc, "/response/error/@code");
//            } catch (UnsupportedEncodingException e) {
//                throw new Exception("(������ ID)������ ������ �� ������� ������", e);
//            }
//
//            throw new Exception("(������ ID)������ ������ �� ������� ������: response=" + responseCode +
//                    " error=" + errorCode + " message=" + errorMessage + " tech-message=" + errorTechMessage);
//        }
//
//        return result;
    }
}
