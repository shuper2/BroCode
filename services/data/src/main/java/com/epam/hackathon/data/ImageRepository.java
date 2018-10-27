package com.epam.hackathon.data;

import com.epam.hachathon.domain.LostImage;

import java.util.List;

public interface ImageRepository {

    List<LostImage> findAllLostImages();
    LostImage getLostImageById(int lostImageId);
    void insert(List<LostImage> lostImages);
}
