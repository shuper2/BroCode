package com.epam.hackathon.image;

import com.epam.hachathon.domain.FindingCase;
import com.epam.hachathon.domain.LostCase;

interface ImageMatchingApi {
    MatchResult match(final LostCase lostCase, final FindingCase findingCase);
}
