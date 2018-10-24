package com.epam.hackathon.web.request;

public final class ConfirmMatchingRequest {
    private final String userId;
    private final long lostId;
    private final long findingId;

    public ConfirmMatchingRequest(final String userId, final long lostId, final long findingId) {
        this.userId = userId;
        this.lostId = lostId;
        this.findingId = findingId;
    }

    public String getUserId() {
        return userId;
    }
    public long getLostId() {
        return lostId;
    }
    public long getFindingId() {
        return findingId;
    }
}
