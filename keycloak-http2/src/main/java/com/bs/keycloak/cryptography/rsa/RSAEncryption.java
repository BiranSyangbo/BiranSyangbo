package com.bs.keycloak.cryptography.rsa;

import lombok.SneakyThrows;

import javax.crypto.Cipher;

public class RSAEncryption {

    @SneakyThrows
    public static byte[] encrypt(String data, String publicKey) {
        Cipher  cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, RSAUtils.getPublicKey(publicKey));
        return cipher.doFinal(data.getBytes());
    }
}
