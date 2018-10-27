package com.epam.hackathon.web.service;

import com.epam.hackathon.web.request.ImageType;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    String save(MultipartFile file, ImageType imageType) throws IOException;
}
