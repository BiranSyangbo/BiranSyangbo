package com.bs.keycloak.cryptography.rsa;

import lombok.SneakyThrows;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSAUtils {

    @SneakyThrows
    public static PublicKey getPublicKey(String encodePublicKey) {
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(encodePublicKey));
        KeyFactory rsa = KeyFactory.getInstance("RSA");
        return rsa.generatePublic(keySpec);
    }

    @SneakyThrows
    public static PrivateKey getPrivateKey(String encodedPrivateKey) {
        KeyFactory rsa = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(encodedPrivateKey));
        return rsa.generatePrivate(keySpec);
    }
}
