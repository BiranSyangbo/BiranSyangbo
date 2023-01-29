package com.bs.keycloak.cryptography.rsa;

import lombok.SneakyThrows;

import javax.crypto.Cipher;
import java.security.PrivateKey;
import java.util.Base64;

public class RSADecryption {

    @SneakyThrows
    public static String decrypt(byte[] data, PrivateKey privateKey) {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(data));
    }

    public static String decrypt(String data, String privateKey) {
        return decrypt(Base64.getDecoder().decode(data), RSAUtils.getPrivateKey(privateKey));
    }
}
