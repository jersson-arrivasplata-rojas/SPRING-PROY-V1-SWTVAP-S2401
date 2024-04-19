package com.jersson.arrivasplata.swtvap.api.sso.expose;

import org.springframework.web.multipart.MultipartFile;

public interface StorageController {
    String uploadFile(MultipartFile file);
}
