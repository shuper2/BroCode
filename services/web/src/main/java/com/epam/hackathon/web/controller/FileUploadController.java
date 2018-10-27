package com.epam.hackathon.web.controller;

import com.epam.hackathon.web.request.ImageType;
import com.epam.hackathon.web.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
class FileUploadController {
    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    private final FileService fileService;

    FileUploadController(final FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public String uploadImageFile(@RequestPart MultipartFile file,
                                  @RequestParam("image-type") ImageType imageType) {
        logger.info("File uploaded: {} with type:{}", file, imageType);
        fileService.save(file, imageType);
        return "redirect:/found.html";
    }

}
