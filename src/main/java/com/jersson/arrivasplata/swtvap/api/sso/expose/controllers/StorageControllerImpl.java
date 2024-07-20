package com.jersson.arrivasplata.swtvap.api.sso.expose.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jersson.arrivasplata.swtvap.api.sso.business.service.StorageService;

@RestController
@RequestMapping(value = "/api/storages", produces = "application/vnd.swtvap-api-storages.v1+json")
public class StorageControllerImpl {

    @Autowired
    private StorageService storageService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("folderName") String folderName) {
        String keyName = file.getOriginalFilename();
        storageService.uploadFile(keyName, folderName, file);
        return "File uploaded successfully: " + keyName;
    }

    @PutMapping("/update/{keyName}")
    public String updateFile(@PathVariable String keyName, @RequestParam("file") MultipartFile newFile,
        @RequestParam("folderName") String folderName) {
        storageService.updateFile(keyName, folderName, newFile);
        return "File updated successfully: " + keyName;
    }

    @DeleteMapping("/delete/{keyName}")
    public String removeFile(@PathVariable String keyName, @RequestParam("folderName") String folderName) {
        storageService.removeFile(keyName, folderName);
        return "File deleted successfully: " + keyName;
    }

    @GetMapping("/list")
    public List<String> listFiles(@RequestParam("folderName") String folderName) {
        return storageService.listFiles(folderName);
    }

    @GetMapping("/download/{keyName}")
    public String downloadFile(@PathVariable String keyName, @RequestParam("folderName") String folderName,
        @RequestParam("localFilePath") String localFilePath) {
        storageService.downloadFile(keyName, folderName, localFilePath);
        return "File downloaded successfully: " + keyName;
    }
    // Agregar endpoints para descargar, eliminar, etc.
}