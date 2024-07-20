package com.jersson.arrivasplata.swtvap.api.sso.expose;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface StorageController {
    String uploadFile(MultipartFile file, String folderName);

    String updateFile(String keyName, MultipartFile newFile, String folderName);

    String removeFile(String keyName, String folderName);

    List<String> listFiles(String folderName);

    String downloadFile(String keyName, String folderName, String localFilePath);
}
