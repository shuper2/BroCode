package com.epam.hackathon.web.request;

public final class LostQueryRequest {
    private final String userId;
    private final double latitude;
    private final double longitude;

    public LostQueryRequest(final String userId, final double latitude, final double longitude) {
        this.userId = userId;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getUserId() {
        return userId;
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
}
