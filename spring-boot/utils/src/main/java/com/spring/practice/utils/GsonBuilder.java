package com.spring.practice.utils;

import com.google.gson.Gson;

public class GsonBuilder {

    public static Gson gson(){
        return  new com.google.gson.GsonBuilder()
                .enableComplexMapKeySerialization()
                .setPrettyPrinting()
                .create();
    }
}
