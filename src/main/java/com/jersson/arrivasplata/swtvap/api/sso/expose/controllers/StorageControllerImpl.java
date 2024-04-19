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
@RequestMapping("/api/storage")
public class StorageControllerImpl {

    @Autowired
    private StorageService storageService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        String keyName = file.getOriginalFilename();
        storageService.uploadFile(keyName, file);
        return "File uploaded successfully: " + keyName;
    }
    @PutMapping("/update/{keyName}")
    public String updateFile(@PathVariable String keyName, @RequestParam("file") MultipartFile newFile) {
        storageService.updateFile(keyName, newFile);
        return "File updated successfully: " + keyName;
    }

    @DeleteMapping("/delete/{keyName}")
    public String removeFile(@PathVariable String keyName) {
        storageService.removeFile(keyName);
        return "File deleted successfully: " + keyName;
    }

    @GetMapping("/list")
    public List<String> listFiles() {
        return storageService.listFiles();
    }
    // Agregar endpoints para descargar, eliminar, etc.
}