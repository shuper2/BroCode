package com.epam.hackathon.web.controller;

import com.epam.hackathon.web.request.ImageType;
import com.epam.hackathon.web.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
class FileUploadController {
    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    private final FileService fileService;

    FileUploadController(final FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public String uploadImageFile(@RequestPart MultipartFile file,
                                  @RequestParam("image-type") ImageType imageType,
                                  RedirectAttributes redirectAttributes) throws IOException {
        logger.info("File uploaded: {} with type:{}", file.getOriginalFilename(), imageType);
        String filename = fileService.save(file, imageType);
        redirectAttributes.addAttribute("message", "File uploaded.");
        redirectAttributes.addAttribute("filename", filename);
        return "redirect:/found.html";
    }

}
