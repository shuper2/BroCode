package com.epam.hackathon.data;

import com.epam.hachathon.domain.FindingCase;
import com.epam.hachathon.domain.LostCase;

import java.util.List;

public interface CaseRepository {

    static CaseRepository newInstance(){
        return new CaseRepositoryImpl();
    }

    FindingCase getFindingCaseById(final long findingId);

    long saveFindingCase(final FindingCase findingCase);

    List<FindingCase> getFindingCases(final long lostId);

    void confirmMatch(final String userId, final long lostId, final long findingId);

    List<LostCase> fetchLostCasesByPreference(final Preference preference);

    List<LostCase> fetchUserLostCases(final String userId, final int pageNum);

    LostCase getLostCaseById(final long lostId);

    long saveLostCase(final LostCase lostCase);
}
