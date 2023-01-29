package com.bs.keycloak.cryptography.rsa;

import lombok.Getter;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class RSAKeyPairGenerator {

    @Getter
    private PrivateKey privateKey;
    @Getter
    private PublicKey publicKey;

    @SneakyThrows
    public RSAKeyPairGenerator() {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair keyPair = generator.genKeyPair();
        this.privateKey = keyPair.getPrivate();
        this.publicKey = keyPair.getPublic();
    }

    @SneakyThrows
    public void writeToFile(String path, byte[] key) {
        File file = new File(path);
        file.getParentFile().mkdir();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(key);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

}
