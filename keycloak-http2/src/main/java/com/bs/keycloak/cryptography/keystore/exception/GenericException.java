package com.bs.keycloak.cryptography.keystore.exception;

public class GenericException extends RuntimeException {
    public GenericException(String s, Exception e) {
        super(s, e);
    }
}
