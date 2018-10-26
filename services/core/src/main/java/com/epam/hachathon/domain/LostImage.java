package com.epam.hachathon.domain;

import java.util.Collections;
import java.util.List;

public class LostImage {

    private Integer lostImageId;
    private String lostImagePath;
    private List<FoundImage> foundImages = Collections.emptyList();

    public Integer getLostImageId() {
        return lostImageId;
    }

    public void setLostImageId(Integer lostImageId) {
        this.lostImageId = lostImageId;
    }

    public String getLostImagePath() {
        return lostImagePath;
    }

    public void setLostImagePath(String lostImagePath) {
        this.lostImagePath = lostImagePath;
    }

    public List<FoundImage> getFoundImages() {
        return foundImages;
    }

    public void setFoundImages(List<FoundImage> foundImages) {
        this.foundImages = foundImages;
    }
}
