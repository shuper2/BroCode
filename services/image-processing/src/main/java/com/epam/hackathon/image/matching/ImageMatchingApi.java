package com.epam.hackathon.image.matching;

import com.epam.hachathon.domain.FindingCase;
import com.epam.hachathon.domain.LostCase;

interface ImageMatchingApi {
    MatchResult match(final LostCase lostCase, final FindingCase findingCase);
}
