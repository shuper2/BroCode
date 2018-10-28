package com.epam.hackathon.web.controller;

import com.epam.hackathon.data.ImageRepository;
import com.epam.hackathon.domain.LostImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ImageController {

    private final ImageRepository imageRepository;

    @Autowired
    ImageController(final ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @PostMapping("/matches")
    @ResponseBody
    public LostImage getMatches(){
        //todo
        return imageRepository.getLostImageById(1);
    }
}
