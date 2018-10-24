package com.epam.hackathon.web.request;

public final class LostMatchQueryRequest {
    private final String userId;
    private final long lostId;

    public LostMatchQueryRequest(final String userId, final long lostId) {
        this.userId = userId;
        this.lostId = lostId;
    }

    public String getUserId() {
        return userId;
    }
    public long getLostId() {
        return lostId;
    }
}
