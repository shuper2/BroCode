package com.epam.hackathon.data;

import com.epam.hachathon.domain.Match;

public interface MatchRepository {
    long saveMatch(final Match match);

    Match fetchCasePairAsNewMatch();
}
