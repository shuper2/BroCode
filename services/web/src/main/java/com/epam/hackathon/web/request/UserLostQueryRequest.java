package com.epam.hackathon.web.request;

public final class UserLostQueryRequest {
    private final String userId;
    private final int pageNum;

    public UserLostQueryRequest(final String userId, final int pageNum) {
        this.userId = userId;
        this.pageNum = pageNum;
    }
    public String getUserId() {
        return userId;
    }
    public int getPageNum() {
        return pageNum;
    }
}
