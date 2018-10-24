package com.epam.hachathon.domain;

public final class Match {
    private final long id;
    private final long lostId;
    private final long findingId;
    private final boolean isIntended;
    private int probability = -1;
    private boolean isConfirmed = false;

    public Match(final long id, final long lostId, final long findingId, final boolean isIntended) {
        this.id = id;
        this.lostId = lostId;
        this.findingId = findingId;
        this.isIntended = isIntended;
    }

    public long getId() {
        return id;
    }
    public long getLostId() {
        return lostId;
    }
    public long getFindingId() {
        return findingId;
    }
    public boolean isIntended() {
        return isIntended;
    }
    public int getProbability() {
        return probability;
    }
    public void setProbability(final int probability) {
        this.probability = probability;
    }
    public boolean isConfirmed() {
        return isConfirmed;
    }
    public void setConfirmed(final boolean confirmed) {
        isConfirmed = confirmed;
    }
}
