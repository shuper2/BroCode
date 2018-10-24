package com.epam.hachathon.domain;

import java.time.ZonedDateTime;

public final class FindingCase {
    private final long id;
    private final String userId;
    private final ZonedDateTime captureTime;
    private final double latitude;
    private final double longitude;
    private final String imageUrl;
    private final long intendedLostId;
    private int highestProbability = 0;

    public FindingCase(final long id,
                       final String userId,
                       final ZonedDateTime captureTime,
                       final double latitude,
                       final double longitude,
                       final String imageUrl,
                       final long intendedLostId) {
        this.id = id;
        this.userId = userId;
        this.captureTime = captureTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imageUrl = imageUrl;
        this.intendedLostId = intendedLostId;
    }

    public long getId() {
        return id;
    }
    public String getUserId() {
        return userId;
    }
    public ZonedDateTime getCaptureTime() {
        return captureTime;
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public long getIntendedLostId() {
        return intendedLostId;
    }
    public int getHighestProbability() {
        return highestProbability;
    }
    public void setHighestProbability(final int highestProbability) {
        this.highestProbability = highestProbability;
    }
}
