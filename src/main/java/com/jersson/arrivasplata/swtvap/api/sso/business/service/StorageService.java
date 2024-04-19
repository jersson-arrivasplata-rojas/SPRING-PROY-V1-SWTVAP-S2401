package com.jersson.arrivasplata.swtvap.api.sso.business.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    void uploadFile(String keyName, MultipartFile uploadFilePath);

    void updateFile(String keyName, MultipartFile newFile);

    void removeFile(String keyName);

    List<String> listFiles();
}
