package com.bs.keycloak.cryptography.keystore;

import com.bs.keycloak.cryptography.keystore.exception.CryptographicException;
import com.bs.keycloak.cryptography.keystore.exception.GenericException;
import lombok.SneakyThrows;
import org.springframework.util.ResourceUtils;

import javax.crypto.Cipher;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.Base64;

public class Keystore {

    public static String encrypt(String value, String encoding, String keyStorePassword, String certificateAlias, boolean usePrivateKey) {
        try {
            Key key;
            if (usePrivateKey)
                key = loadCertificatePrivateKey(keyStorePassword, certificateAlias);
            else {
                X509Certificate cert = loadCertificate(keyStorePassword, certificateAlias);
                key = cert.getPublicKey();
            }
            Charset charset = Charset.forName(encoding);
            Cipher encryptor = Cipher.getInstance("RSA");
            encryptor.init(Cipher.ENCRYPT_MODE, key);
            return Base64.getEncoder().encodeToString(encryptor.doFinal(Base64.getDecoder().decode(value.getBytes(charset))));
        } catch (Exception e) {
            throw new CryptographicException(e);
        }
    }


    public static String decrypt(String value, String encoding, String keyStorePassword, String certificateAlias, boolean usePrivateKey) {
        try {
            Key key;
            if (usePrivateKey)
                key = loadCertificatePrivateKey(keyStorePassword, certificateAlias);
            else {
                X509Certificate cert = loadCertificate(keyStorePassword, certificateAlias);
                key = cert.getPublicKey();
            }
            Cipher encryptor = Cipher.getInstance("RSA");
            encryptor.init(Cipher.DECRYPT_MODE, key);
            return new String(encryptor.doFinal(Base64.getDecoder().decode(value.getBytes(StandardCharsets.UTF_8))), encoding);
        } catch (Exception e) {
            throw new CryptographicException(e);
        }
    }


    public static X509Certificate loadCertificate(String keyStorePassword, String certificateAlias) {
        try {
            KeyStore keystore = loadKeyStore(keyStorePassword);
            return (X509Certificate) keystore.getCertificate(certificateAlias);
        } catch (Exception e) {
            throw new GenericException("Failed to load certificate, alias: " + certificateAlias, e);
        }
    }

    public static Key loadCertificatePrivateKey(String keyStorePassword, String certificateAlias) {
        try {
            KeyStore keystore = loadKeyStore(keyStorePassword);
            return keystore.getKey(certificateAlias, keyStorePassword.toCharArray());
        } catch (Exception e) {
            throw new GenericException("Failed to load certificate private key, certificateAlias: " + certificateAlias, e);
        }
    }


    @SneakyThrows
    public static KeyStore loadKeyStore(String keyStorePassword) {
        URL resource = ResourceUtils.getURL("classpath:keystore.jks");
        try (FileInputStream is = new FileInputStream(new File(resource.toURI()))) {
            KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
            keystore.load(is, keyStorePassword.toCharArray());
            return keystore;
        } catch (Exception e) {
            throw new GenericException("Failed to load keystore", e);
        }
    }
}
