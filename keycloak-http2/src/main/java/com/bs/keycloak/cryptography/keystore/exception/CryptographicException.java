package com.bs.keycloak.cryptography.keystore.exception;

public class CryptographicException extends RuntimeException {
    public CryptographicException(Exception e) {
        super(e);
    }
}
