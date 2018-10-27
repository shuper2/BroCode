package com.epam.hackathon.data;

import com.epam.hachathon.domain.LostImage;

import java.util.List;

public interface ImageRepository {

    List<LostImage> findAllLostImages();
    void insert(List<LostImage> lostImages);
}
