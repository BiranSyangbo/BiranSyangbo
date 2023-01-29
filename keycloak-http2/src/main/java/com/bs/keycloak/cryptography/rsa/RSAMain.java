package com.bs.keycloak.cryptography.rsa;

import java.util.Base64;

public class RSAMain {

    public static void main(String[] args) {
        RSAKeyPairGenerator generator = new RSAKeyPairGenerator();
        generator.writeToFile("RSA/publicKey", generator.getPublicKey().getEncoded());
        generator.writeToFile("RSA/privateKey", generator.getPrivateKey().getEncoded());
        String publicKey = Base64.getEncoder().encodeToString(generator.getPublicKey().getEncoded());
        String privateKey = Base64.getEncoder().encodeToString(generator.getPrivateKey().getEncoded());
        String encryptString = Base64.getEncoder().encodeToString(RSAEncryption.encrypt("Biran Syangbo", publicKey));
        String decrypt = RSADecryption.decrypt(encryptString, privateKey);
        System.out.println(decrypt);
    }
}
