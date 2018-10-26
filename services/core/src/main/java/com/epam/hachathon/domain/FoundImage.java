package com.epam.hachathon.domain;

public class FoundImage {

    private Integer foundImageId;
    private String foundImagePath;
    private Double matchPercentage;

    public Integer getFoundImageId() {
        return foundImageId;
    }

    public void setFoundImageId(Integer foundImageId) {
        this.foundImageId = foundImageId;
    }

    public String getFoundImagePath() {
        return foundImagePath;
    }

    public void setFoundImagePath(String foundImagePath) {
        this.foundImagePath = foundImagePath;
    }

    public Double getMatchPercentage() {
        return matchPercentage;
    }

    public void setMatchPercentage(Double matchPercentage) {
        this.matchPercentage = matchPercentage;
    }
}
