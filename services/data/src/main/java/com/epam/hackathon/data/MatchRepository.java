package com.epam.hackathon.data;

import com.epam.hachathon.domain.Match;

public interface MatchRepository {

    static MatchRepository newInstance(){
        return new MatchRepositoryImpl();
    }

    long saveMatch(final Match match);

    Match fetchCasePairAsNewMatch();
}
