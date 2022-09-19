package com.ameshi.csvupload.csvupload.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadingService {
    public String fileUploading(MultipartFile file);
}
