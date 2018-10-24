package com.epam.hackathon.data;

import com.epam.hachathon.domain.FindingCase;
import com.epam.hachathon.domain.LostCase;

import java.util.List;

class CaseRepositoryImpl implements CaseRepository {
    @Override
    public FindingCase getFindingCaseById(final long findingId) {
        //TODO: not implemented
        throw new AssertionError("Not implemented");
    }
    @Override
    public long saveFindingCase(final FindingCase findingCase) {
        //TODO: not implemented
        throw new AssertionError("Not implemented");
    }
    @Override
    public List<FindingCase> getFindingCases(final long lostId) {
        //TODO: not implemented
        throw new AssertionError("Not implemented");
    }
    @Override
    public void confirmMatch(final String userId, final long lostId, final long findingId) {
        //TODO: not implemented
        throw new AssertionError("Not implemented");
    }
    @Override
    public List<LostCase> fetchLostCasesByPreference(final Preference preference) {
        //TODO: not implemented
        throw new AssertionError("Not implemented");
    }
    @Override
    public List<LostCase> fetchUserLostCases(final String userId, final int pageNum) {
        //TODO: not implemented
        throw new AssertionError("Not implemented");
    }
    @Override
    public LostCase getLostCaseById(final long lostId) {
        //TODO: not implemented
        throw new AssertionError("Not implemented");
    }
    @Override
    public long saveLostCase(final LostCase lostCase) {
        //TODO: not implemented
        throw new AssertionError("Not implemented");
    }
}
