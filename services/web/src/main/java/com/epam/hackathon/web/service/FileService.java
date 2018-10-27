package com.epam.hackathon.web.service;

import com.epam.hackathon.web.request.ImageType;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    void save(MultipartFile file, ImageType imageType);
}
