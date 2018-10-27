package com.epam.hackathon.web.controller;

import com.epam.hackathon.data.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
class FileUploadController {
    private final ImageRepository imageRepository;

    @Autowired
    public FileUploadController(final ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @RequestMapping("/upload")
    public Long uploadImageFile(@RequestBody MultipartFile file){
        return 1L;
    }

}
