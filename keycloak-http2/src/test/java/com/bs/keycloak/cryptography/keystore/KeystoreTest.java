package com.bs.keycloak.cryptography.keystore;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Base64;
import java.util.Queue;

import static com.bs.keycloak.cryptography.keystore.Keystore.decrypt;
import static com.bs.keycloak.cryptography.keystore.Keystore.encrypt;
import static org.junit.jupiter.api.Assertions.*;

class KeystoreTest {

    @Test
    void testCase() {
        String text = "Hello This is the secret message which should not be seen by others got it";
        String encrypt = encrypt(Base64.getEncoder().encodeToString(text.getBytes()), "UTF-8", "bnpl-microfinance", "bnpl-microfinance", false);
        String decrypt = decrypt(encrypt, "UTF-8", "bnpl-microfinance", "bnpl-microfinance", true);
        assertEquals(text, decrypt);
    }



}