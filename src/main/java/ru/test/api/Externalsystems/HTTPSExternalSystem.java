package ru.test.api.Externalsystems;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.CryptoPro.JCP.JCP;
import ru.test.api.Helpers.StringHelper;
import ru.test.api.exceptions.AxiLinkException;
import ru.test.api.exceptions.ExternalSystemArgumentException;
import ru.test.api.exceptions.ExternalSystemCryptoException;
import ru.test.api.exceptions.ExternalSystemException;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.Map;

/**
 * Created by tikhonin on 18.01.2016.
 */
public abstract class HTTPSExternalSystem extends AbstractExternalSystem {

    private CloseableHttpClient httpClient;

    private Logger log = LoggerFactory.getLogger(getClass());

    private String trustManagerFactoryType; // "GostX509", "PKIX"
    private String sslContextType;  // "GostTLS",  "TLSv1.2"

    public HTTPSExternalSystem(String connectionString, String trustManagerFactoryType, String sslContextType) {
        super(connectionString);

        this.trustManagerFactoryType = trustManagerFactoryType;
        this.sslContextType = sslContextType;
    }

    /**
     * Получение HTTP клиента
     * @return HTTP клиент
     * @throws ExternalSystemCryptoException
     */
    protected CloseableHttpClient getHHTPClient() throws ExternalSystemCryptoException, AxiLinkException {
        if (httpClient == null) {
            System.setProperty("javax.net.debug", "ssl");
            System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
            System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
            System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire.header", "debug");
            System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient", "debug");

            SSLContext sc = null;
            //try {
            TrustManagerFactory trustManagerFactory = null;
            try {
                KeyStore trustStore = null;
                trustStore = KeyStore.getInstance(JCP.HD_STORE_NAME);
                trustStore.load(new FileInputStream("C:/CryptoPro/Certificate Stores/certs"), "changeit".toCharArray());
                log.debug("TrustStore загружен");

                trustManagerFactory = TrustManagerFactory.getInstance(trustManagerFactoryType);
                trustManagerFactory.init(trustStore);
                log.debug("TrustStore инициализирован");
            } catch (KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException e) {
                throw new ExternalSystemCryptoException("Ошибка инициализации криптографической подсистемы. Ошибка инициализации TrustStore: " + e.getMessage(), e);
            }

            KeyManager[] keyManagers = null;
            if (getConnectionParams().containsKey("keystore")) {
                try {
                    if(!getConnectionParams().containsKey("keystoretype") || !getConnectionParams().containsKey("keystorepassword")) {
                        throw new ExternalSystemCryptoException("Ошибка инициализации криптографической подсистемы. Указаны не корректные keystoretype и keystorepassword");
                    }

                    KeyStore keyStore = null;
                    keyStore = KeyStore.getInstance(getConnectionParams().get("keystoretype"));
                    keyStore.load(new FileInputStream(getConnectionParams().get("keystore")), getConnectionParams().get("keystorepassword").toCharArray());
                    log.debug("KeyStore загружен");

                    //для клиентской атетнититификации(two-way TLS) имя(alias) сертификата должно начинаться с .0.
                    //подробнее смотреть в реализации метода getEntry класса X509KeyManagerImpl
                    KeyManagerFactory kmf = KeyManagerFactory.getInstance(trustManagerFactoryType);
                    kmf.init(keyStore, getConnectionParams().get("keystorepassword").toCharArray());
                    keyManagers = kmf.getKeyManagers();
                    log.debug("KeyStore инициализирован");
                } catch (KeyStoreException | CertificateException | UnrecoverableKeyException | NoSuchAlgorithmException |  IOException e) {
                    throw new ExternalSystemCryptoException("Ошибка инициализации криптографической подсистемы. Ошибка инициализации KeyStore: " + e.getMessage(), e);
                }

            }

            try {
                sc = SSLContext.getInstance(sslContextType);
                sc.init(keyManagers, trustManagerFactory.getTrustManagers(), SecureRandom.getInstance(JCP.CP_RANDOM, JCP.PROVIDER_NAME));
            } catch (KeyManagementException | NoSuchAlgorithmException | NoSuchProviderException e) {
                throw new ExternalSystemCryptoException("Ошибка инициализации криптографической подсистемы. Ошибка инициализации SSLContext: " + e.getMessage(), e);
            }
            log.debug("SSL контекст инициализирован");
            //CloseableHttpClient httpclient = HttpClients.createDefault();

            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(30000).setConnectionRequestTimeout(30000).setSocketTimeout(30000).build();

            if (getCredentialsProvider() == null) {
                httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig).setSSLContext(sc).build();
            } else {
                httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig).setSSLContext(sc).setDefaultCredentialsProvider(getCredentialsProvider()).build();
            }
            log.info("HttpClient кэширован");
        }

        return httpClient;
    }

    /**
     * Запрос ко API внешней системы
     * @param requestParams Параметры запроса
     * @return Сырой ответ от внешней систмы
     * @throws IOException
     * @throws AxiLinkException
     * @throws ExternalSystemCryptoException
     */
    protected HttpEntity requestRawApi(List<NameValuePair> requestParams) throws IOException, AxiLinkException, ExternalSystemCryptoException, ExternalSystemArgumentException, ExternalSystemException {

        String url = this.getConnectionParams().get("url");

        HttpEntity response = null;
        try {
            response = requestRawApi(requestParams, new URI(url));
        } catch (URISyntaxException e) {
            throw new ExternalSystemArgumentException("Ошибка формирования URI");
        }

        return response;
    }

    /**
     * Запрос ко API внешней системы
     * @param requestParams Параметры запроса
     * @param uri Адрес обращения
     * @return Сырой ответ от внешней систмы
     * @throws IOException
     * @throws AxiLinkException
     * @throws ExternalSystemCryptoException
     */
    protected HttpEntity requestRawApi(List<NameValuePair> requestParams, URI uri) throws IOException, AxiLinkException, ExternalSystemCryptoException, ExternalSystemArgumentException, ExternalSystemException {

        HttpEntity result = null;

        if(StringHelper.isNullOrEmpty(uri.toString())) {
            throw new ExternalSystemArgumentException("Отсутвует параметр url");
        }
        log.debug("Пытаемся открыть {}", uri.toString());
        HttpPost httpPost = new HttpPost(uri);
        HttpEntity requestEntitty = getHttpEntity(requestParams);
        httpPost.setEntity(requestEntitty);

        setHeaders(httpPost);

        CloseableHttpResponse response = getHHTPClient().execute(httpPost);
        result = response.getEntity();
        return result;
    }

    /**
     * Запрос ко API внешней системы
     * @param requestParams Параметры запроса
     * @return Ответ от внешней систмы
     * @throws IOException
     * @throws AxiLinkException
     * @throws ExternalSystemCryptoException
     */
    protected String requestApi(List<NameValuePair> requestParams) throws IOException, AxiLinkException, ExternalSystemCryptoException, ExternalSystemArgumentException, ExternalSystemException {

        String result = null;
        HttpEntity responseEntity = requestRawApi(requestParams);
        result = EntityUtils.toString(responseEntity);
        return result;
    }

    /**
     * Запрос ко API внешней системы
     * @param requestParams Параметры запроса
     * @param codec Кодировка ответа от внешней системы
     * @return Ответ от внешней систмы
     * @throws IOException
     * @throws AxiLinkException
     * @throws ExternalSystemCryptoException
     */
    protected String requestApi(List<NameValuePair> requestParams, String codec) throws IOException, AxiLinkException, ExternalSystemCryptoException, ExternalSystemArgumentException, ExternalSystemException {

        String result = null;
        HttpEntity responseEntity = requestRawApi(requestParams);
        result = EntityUtils.toString(responseEntity, codec);
        return result;
    }

    /**
     * Запрос ко API внешней системы
     * @param requestParams Параметры запроса
     * @param uri Адрес обращения
     * @return Ответ от внешней систмы
     * @throws IOException
     * @throws AxiLinkException
     * @throws ExternalSystemCryptoException
     */
    protected String requestApi(List<NameValuePair> requestParams, URI uri) throws IOException, AxiLinkException, ExternalSystemCryptoException, ExternalSystemArgumentException, ExternalSystemException {

        String result = null;
        HttpEntity responseEntity = requestRawApi(requestParams, uri);
        result = EntityUtils.toString(responseEntity);
        return result;
    }

    /**
     * Формирование HttpEntity на основе парметров запроса к API внешней системы
     * @param requestParams Парметры запроса
     * @return
     */
    protected abstract HttpEntity getHttpEntity(List<NameValuePair> requestParams) throws ExternalSystemException;

    protected void setHeaders(HttpPost httpPost) {

    }

    protected CredentialsProvider getCredentialsProvider() throws AxiLinkException {
        return null;
    }
}
