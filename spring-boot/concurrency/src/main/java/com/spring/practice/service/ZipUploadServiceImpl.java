package com.spring.practice.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@Service
public class ZipUploadServiceImpl implements ZipUploadService {

    String fileUploadPath = "/home/deadhead-bs/Downloads/1 Chronicles.zip";

    @Override
    @SneakyThrows
    public boolean uploadZipFile(MultipartFile mPart) {
        ZipFile zipFile = new ZipFile(fileUploadPath);
        zipFile.stream().filter(d -> !d.isDirectory())
                .map(f -> extractZip(zipFile, f))
                .collect(Collectors.collectingAndThen(Collectors.toList(), completableFutures -> completableFutures.stream().map(CompletableFuture::join))
                ).collect(Collectors.toList());
        return false;
    }

    private CompletableFuture<String> extractZip(ZipFile zipFile, ZipEntry f) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        return CompletableFuture.supplyAsync(() -> extractJSONFile(zipFile, f), executorService);
    }

    @SneakyThrows
    public String extractJSONFile(ZipFile file, ZipEntry entry) {
        System.out.println(Thread.currentThread().getName());
        System.out.println("entry.getName() = " + entry.getName());
        InputStream inputStream = file.getInputStream(entry);

        return "";
    }
}