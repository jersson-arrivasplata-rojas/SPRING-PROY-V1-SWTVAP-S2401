package com.jersson.arrivasplata.swtvap.api.sso.business.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    void uploadFile(String keyName, String folderName, MultipartFile uploadFilePath);

    void updateFile(String keyName, String folderName, MultipartFile newFile);

    void removeFile(String keyName, String folderName);

    List<String> listFiles(String folderName);

    void downloadFile(String keyName, String folderName, String localFilePath);
}
