package ru.test.api.Helpers;

import com.objsys.asn1j.runtime.*;
import ru.CryptoPro.JCP.ASN.CryptographicMessageSyntax.*;
import ru.CryptoPro.JCP.ASN.PKIX1Explicit88.CertificateSerialNumber;
import ru.CryptoPro.JCP.ASN.PKIX1Explicit88.Name;
import ru.CryptoPro.JCP.JCP;
import ru.CryptoPro.JCP.params.OID;
import ru.test.api.exceptions.AxiLinkException;
import sun.misc.BASE64Encoder;
import sun.security.pkcs.PKCS7;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.x509.AlgorithmId;
import sun.security.x509.X500Name;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.*;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Created by tikhonin on 16.03.2016.
 */
public class CMSHelper {

    public static final String STR_CMS_OID_DATA = "1.2.840.113549.1.7.1";
    public static final String STR_CMS_OID_SIGNED = "1.2.840.113549.1.7.2";

    //TODO: Добавить метод проверки VerifyCMS

    public static byte[] unsignPKCS7(byte[] cmsbuffer) throws Asn1Exception, IOException {
        Asn1BerDecodeBuffer asnBuf = new Asn1BerDecodeBuffer(cmsbuffer);
        ContentInfo contInfo = new ContentInfo();
        contInfo.decode(asnBuf);
        SignedData cms = (SignedData) contInfo.content;
        byte[] data = cms.encapContentInfo.eContent.value; //это оно есть
        return data;
    }

    public static byte[] signPKCS7(String storeName, String password, byte[] data) throws UnrecoverableKeyException, CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, InvalidKeyException, SignatureException, NoSuchProviderException, Asn1Exception, AxiLinkException {
        //load keys for sign
        final PrivateKey[] keys = new PrivateKey[1];
        keys[0] = loadKey(storeName, password.toCharArray());

        if(keys[0] == null)
            throw new AxiLinkException("Ошибка загрузки приватного ключа: " + storeName);

        final Certificate[] certs = new Certificate[1];
        certs[0] = loadCertificate(storeName);

        if(keys[0] == null)
            throw new AxiLinkException("Ошибка загрузки сертификата: " + storeName);

        final Asn1BerDecodeBuffer asnBuf = new Asn1BerDecodeBuffer(data);
        final ContentInfo all = new ContentInfo();

        byte [] cmsData = null;
        cmsData = createCMS(data, keys, certs, false);

        byte [] result = null;
        result = signCMS(cmsData, keys, certs, null);

        return result;
    }

    /**
     * Получение PrivateKey из store.
     *
     * @param name alias ключа
     * @param password пароль на ключ
     * @return PrivateKey
     * @throws Exception in key read
     */
    public static PrivateKey loadKey(String name, char[] password) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException, UnrecoverableKeyException {
        final KeyStore hdImageStore = KeyStore.getInstance(JCP.HD_STORE_NAME);
        hdImageStore.load(null, null);
        return (PrivateKey) hdImageStore.getKey(name, password);
    }

    /**
     * Получение certificate из store.
     *
     * @param name alias сертификата.
     * @return Certificate
     * @throws Exception in cert read
     */
    public static Certificate loadCertificate(String name) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {
        final KeyStore hdImageStore = KeyStore.getInstance(JCP.HD_STORE_NAME);
        hdImageStore.load(null, null);
        return hdImageStore.getCertificate(name);
    }


    /**
     * Создание сообщение с подписью на хэш данных
     *
     * @param data data
     * @param certs certs[]
     * @param keys keys
     * @param detached true if detached
     * @return byte[]
     * @throws Exception e
     */
    private static byte[] createCMS(byte[] data, PrivateKey[] keys, Certificate[] certs, boolean detached) throws Asn1Exception, NoSuchAlgorithmException, CertificateEncodingException, SignatureException, NoSuchProviderException, InvalidKeyException, IOException {
        return createCMSEx(data, keys, certs, detached, JCP.GOST_DIGEST_OID, JCP.GOST_EL_KEY_OID, JCP.GOST_EL_SIGN_NAME, JCP.PROVIDER_NAME);
    }

    private static byte[] createCMSEx(byte[] data, PrivateKey[] keys, Certificate[] certs, boolean detached, String digestOid, String signOid, String signAlg, String providerName) throws CertificateEncodingException, Asn1Exception, IOException, NoSuchProviderException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        //create CMS
        final ContentInfo all = new ContentInfo();
        all.contentType = new Asn1ObjectIdentifier(new OID(STR_CMS_OID_SIGNED).value);

        final SignedData cms = new SignedData();
        all.content = cms;
        cms.version = new CMSVersion(1);

        // digest
        cms.digestAlgorithms = new DigestAlgorithmIdentifiers(1);
        final DigestAlgorithmIdentifier a = new DigestAlgorithmIdentifier(new OID(digestOid).value);
        a.parameters = new Asn1Null();
        cms.digestAlgorithms.elements[0] = a;

        if (detached) {
            cms.encapContentInfo = new EncapsulatedContentInfo(new Asn1ObjectIdentifier(new OID(STR_CMS_OID_DATA).value), null);
        } // if
        else {
            cms.encapContentInfo =
                    new EncapsulatedContentInfo(new Asn1ObjectIdentifier(new OID(STR_CMS_OID_DATA).value), new Asn1OctetString(data));
        } // else

        // certificates
        final int nCerts = certs.length;
        cms.certificates = new CertificateSet(nCerts);
        cms.certificates.elements = new CertificateChoices[nCerts];

        for (int i = 0; i < cms.certificates.elements.length; i++) {

            final ru.CryptoPro.JCP.ASN.PKIX1Explicit88.Certificate certificate = new ru.CryptoPro.JCP.ASN.PKIX1Explicit88.Certificate();
            final Asn1BerDecodeBuffer decodeBuffer = new Asn1BerDecodeBuffer(certs[i].getEncoded());
            certificate.decode(decodeBuffer);

            cms.certificates.elements[i] = new CertificateChoices();
            cms.certificates.elements[i].set_certificate(certificate);

        } // for

        // Signature.getInstance
        final java.security.Signature signature = java.security.Signature.getInstance(signAlg, providerName);
        byte[] sign;

        // signer infos
        final int nSign = keys.length;
        cms.signerInfos = new SignerInfos(nSign);
        for (int i = 0; i < cms.signerInfos.elements.length; i++) {

            signature.initSign(keys[i]);
            signature.update(data);
            sign = signature.sign();

            cms.signerInfos.elements[i] = new SignerInfo();
            cms.signerInfos.elements[i].version = new CMSVersion(1);
            cms.signerInfos.elements[i].sid = new SignerIdentifier();

            final byte[] encodedName = ((X509Certificate) certs[i]).getIssuerX500Principal().getEncoded();
            final Asn1BerDecodeBuffer nameBuf = new Asn1BerDecodeBuffer(encodedName);
            final Name name = new Name();
            name.decode(nameBuf);

            final CertificateSerialNumber num = new CertificateSerialNumber(((X509Certificate) certs[i]).getSerialNumber());
            cms.signerInfos.elements[i].sid.set_issuerAndSerialNumber(new IssuerAndSerialNumber(name, num));
            cms.signerInfos.elements[i].digestAlgorithm = new DigestAlgorithmIdentifier(new OID(digestOid).value);
            cms.signerInfos.elements[i].digestAlgorithm.parameters = new Asn1Null();
            cms.signerInfos.elements[i].signatureAlgorithm = new SignatureAlgorithmIdentifier(new OID(signOid).value);
            cms.signerInfos.elements[i].signatureAlgorithm.parameters = new Asn1Null();
            cms.signerInfos.elements[i].signature = new SignatureValue(sign);
        }

        // encode
        final Asn1BerEncodeBuffer asnBuf = new Asn1BerEncodeBuffer();
        all.encode(asnBuf, true);

        return asnBuf.getMsgCopy();
    }

    /**
     * Подпись существующего сообщения (CMS) //хэш на данные
     *
     * @param buffer CMS
     * @param keys keys
     * @param certs certs
     * @param data data if detached signature
     * @return byte[]
     * @throws Exception e
     */
    private static byte[] signCMS(byte[] buffer, PrivateKey[] keys, Certificate[] certs, byte[] data) throws Asn1Exception, NoSuchAlgorithmException, IOException, SignatureException, NoSuchProviderException, InvalidKeyException, CertificateEncodingException {
        return signCMSEx(buffer, keys, certs, data, JCP.GOST_DIGEST_OID, JCP.GOST_EL_KEY_OID, JCP.GOST_EL_SIGN_NAME, JCP.PROVIDER_NAME);
    }

    /**
     * Подпись существующего сообщения (CMS) //хэш на данные
     *
     * @param buffer CMS
     * @param keys keys
     * @param certs certs
     * @param data data if detached signature
     * @param digestOidValue digest algorithm OID
     * @param signOidValue signature algorithm OID
     * @param signAlg signature algorithm name
     * @param providerName provider name
     * @return byte[]
     * @throws Exception e
     * @since 2.0
     */
    private static byte[] signCMSEx(byte[] buffer, PrivateKey[] keys, Certificate[] certs, byte[] data, String digestOidValue, String signOidValue, String signAlg, String providerName) throws Asn1Exception, IOException, NoSuchProviderException, NoSuchAlgorithmException, InvalidKeyException, SignatureException, CertificateEncodingException {
        int i;
        final Asn1BerDecodeBuffer asnBuf = new Asn1BerDecodeBuffer(buffer);
        final ContentInfo all = new ContentInfo();
        all.decode(asnBuf);

        if (!new OID(STR_CMS_OID_SIGNED).eq(all.contentType.value)) {
            throw new IllegalArgumentException("Not supported");
        } // if

        final SignedData cms = (SignedData) all.content;
        if (cms.version.value != 1) {
            throw new IllegalArgumentException("Incorrect version");
        } // if

        if (!new OID(STR_CMS_OID_DATA).eq(cms.encapContentInfo.eContentType.value)) {
            throw new IllegalArgumentException("Nested not supported");
        } // if

        final byte[] text;
        if (cms.encapContentInfo.eContent != null) {
            text = cms.encapContentInfo.eContent.value;
        } // if
        else if (data != null) {
            text = data;
        } // else
        else {
            throw new IllegalArgumentException("No content");
        } // else

        //    final byte[] text = cms.encapContentInfo.eContent.value;
        OID digestOid = null;
        final DigestAlgorithmIdentifier a = new DigestAlgorithmIdentifier(new OID(digestOidValue).value);

        for (i = 0; i < cms.digestAlgorithms.elements.length; i++) {
            if (cms.digestAlgorithms.elements[i].algorithm.equals(a.algorithm)) {
                digestOid = new OID(cms.digestAlgorithms.elements[i].algorithm.value);
                break;
            } // if
        } // for

        if (digestOid == null) {
            throw new IllegalArgumentException("Unknown digest");
        } // if

        // certificates
        final CertificateChoices[] choices =
                new CertificateChoices[cms.certificates.elements.length];
        for (i = 0; i < cms.certificates.elements.length; i++) {
            choices[i] = cms.certificates.elements[i];
        }  // for

        final int nCerts = certs.length + choices.length;
        cms.certificates = new CertificateSet(nCerts);
        cms.certificates.elements = new CertificateChoices[nCerts];
        for (i = 0; i < choices.length; i++) {
            cms.certificates.elements[i] = choices[i];
        } // for

        for (i = 0; i < cms.certificates.elements.length - choices.length; i++) {

            final ru.CryptoPro.JCP.ASN.PKIX1Explicit88.Certificate certificate = new ru.CryptoPro.JCP.ASN.PKIX1Explicit88.Certificate();
            final Asn1BerDecodeBuffer decodeBuffer = new Asn1BerDecodeBuffer(certs[i].getEncoded());
            certificate.decode(decodeBuffer);
            cms.certificates.elements[i + choices.length] = new CertificateChoices();
            cms.certificates.elements[i + choices.length].set_certificate(certificate);

        } // for

        // Signature.getInstance
        final java.security.Signature signature = java.security.Signature.getInstance(signAlg, providerName);
        byte[] sign;

        // signer infos
        final SignerInfo[] infos = new SignerInfo[cms.signerInfos.elements.length];
        for (i = 0; i < cms.signerInfos.elements.length; i++) {
            infos[i] = cms.signerInfos.elements[i];
        } // for

        final int nsign = keys.length + infos.length;
        cms.signerInfos = new SignerInfos(nsign);
        for (i = 0; i < infos.length; i++) {
            cms.signerInfos.elements[i] = infos[i];
        } // for

        for (i = 0; i < cms.signerInfos.elements.length - infos.length; i++) {

            signature.initSign(keys[i]);
            signature.update(text);
            sign = signature.sign();

            cms.signerInfos.elements[i + infos.length] = new SignerInfo();
            cms.signerInfos.elements[i + infos.length].version = new CMSVersion(1);
            cms.signerInfos.elements[i + infos.length].sid = new SignerIdentifier();

            final byte[] encodedName = ((X509Certificate) certs[i]).getIssuerX500Principal().getEncoded();

            final Asn1BerDecodeBuffer nameBuf = new Asn1BerDecodeBuffer(encodedName);
            final Name name = new Name();
            name.decode(nameBuf);

            final CertificateSerialNumber num = new CertificateSerialNumber(((X509Certificate) certs[i]).getSerialNumber());
            cms.signerInfos.elements[i + infos.length].sid.set_issuerAndSerialNumber(new IssuerAndSerialNumber(name, num));
            cms.signerInfos.elements[i + infos.length].digestAlgorithm = new DigestAlgorithmIdentifier(new OID(digestOidValue).value);
            cms.signerInfos.elements[i + infos.length].digestAlgorithm.parameters = new Asn1Null();
            cms.signerInfos.elements[i + infos.length].signatureAlgorithm = new SignatureAlgorithmIdentifier(new OID(signOidValue).value);
            cms.signerInfos.elements[i + infos.length].signatureAlgorithm.parameters = new Asn1Null();
            cms.signerInfos.elements[i + infos.length].signature = new SignatureValue(sign);
        }

        // encode
        final Asn1BerEncodeBuffer asn1Buf = new Asn1BerEncodeBuffer();
        all.encode(asn1Buf, true);
        return asn1Buf.getMsgCopy();
    }

    public static byte[] sign(byte[] data, PrivateKey key, X509Certificate cert) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, IOException {
        java.security.Signature signature = java.security.Signature.getInstance("Sha1WithRSA");
        signature.initSign(key);
        signature.update(data);
        byte[] signedData = signature.sign();

        X500Name xName = X500Name.asX500Name(cert.getSubjectX500Principal());
        BigInteger serial = cert.getSerialNumber();
        AlgorithmId digestAlgorithmId = new AlgorithmId(AlgorithmId.SHA_oid);
        AlgorithmId signAlgorithmId = new AlgorithmId(AlgorithmId.RSAEncryption_oid);

        sun.security.pkcs.SignerInfo signerInfo = new sun.security.pkcs.SignerInfo(xName, serial, digestAlgorithmId, signAlgorithmId, signedData);
        sun.security.pkcs.ContentInfo contentInfo = new sun.security.pkcs.ContentInfo(sun.security.pkcs.ContentInfo.DIGESTED_DATA_OID, new DerValue(DerValue.tag_OctetString, data));
        PKCS7 pkcs7 = new PKCS7(new AlgorithmId[]{digestAlgorithmId}, contentInfo, new X509Certificate[]{cert}, new sun.security.pkcs.SignerInfo[]{signerInfo});
        ByteArrayOutputStream baos = new DerOutputStream();
        pkcs7.encodeSignedData(baos);
        byte[] encodedPKCS7 = baos.toByteArray();
        return encodedPKCS7;
    }

    public static String signPEM(byte[] data, PrivateKey key, X509Certificate cert) throws IOException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        byte[] encodedPKCS7 = sign(data, key, cert);

        BASE64Encoder encoder = new BASE64Encoder();

        return "-----BEGIN PKCS7-----" + "\n" + new String(encoder.encode(encodedPKCS7)) + "\n" + "-----END PKCS7-----";
    }
}
