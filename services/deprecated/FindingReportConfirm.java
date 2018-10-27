package com.epam.hackathon.web.response;

public class FindingReportConfirm {
    private final long findingId;
    public FindingReportConfirm(final long findingId) {
        this.findingId = findingId;
    }

    public long getFindingId() {
        return findingId;
    }
}
