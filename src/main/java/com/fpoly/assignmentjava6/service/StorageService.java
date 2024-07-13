package com.fpoly.assignmentjava6.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StorageService {
    void init();
    void store(MultipartFile file);
}
