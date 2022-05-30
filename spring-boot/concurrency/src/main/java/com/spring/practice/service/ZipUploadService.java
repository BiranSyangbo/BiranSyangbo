package com.spring.practice.service;

import org.springframework.web.multipart.MultipartFile;

public interface ZipUploadService {

    boolean uploadZipFile(MultipartFile file);

}
