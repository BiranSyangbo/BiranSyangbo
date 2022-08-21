package com.spring.practice.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.spring.practice.dto.VerseDto;
import com.spring.practice.utils.GsonBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class BatchProcessingServiceImpl implements BatchProcessingService{

    @Override
    public void batchProcessing(InputStream stream) {
        Gson gson = GsonBuilder.gson();
        Type typeToken = new TypeToken<List<VerseDto>>() {
        }.getType();
        List<VerseDto> verseDtos = gson.fromJson(new InputStreamReader(stream), typeToken);

    }
}
