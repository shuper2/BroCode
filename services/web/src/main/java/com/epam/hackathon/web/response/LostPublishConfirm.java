package com.epam.hackathon.web.response;

public final class LostPublishConfirm {
    private final long lostId;
    public LostPublishConfirm(final long lostId) {
        this.lostId = lostId;
    }
    public long getLostId() {
        return lostId;
    }
}
