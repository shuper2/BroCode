package com.epam.hackathon.image.matching;

import com.epam.hachathon.domain.FindingCase;
import com.epam.hachathon.domain.LostCase;
import com.epam.hachathon.domain.Match;
import com.epam.hackathon.data.CaseRepository;
import com.epam.hackathon.data.MatchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
class MatchingService {
    private static final Logger logger = LoggerFactory.getLogger(MatchingService.class);

    private final ImageMatchingApi api;
    private final CaseRepository caseRepository;
    private final MatchRepository matchRepository;
    private final long sleepDuration;

    MatchingService(final ImageMatchingApi api,
                    final CaseRepository caseRepository,
                    final MatchRepository matchRepository,
                    @Value("${image.processing.fetching.interval}") final long sleepDuration) {
        this.api = api;
        this.caseRepository = caseRepository;
        this.matchRepository = matchRepository;
        this.sleepDuration = sleepDuration;
    }

    @Scheduled(fixedDelayString = "${image.processing.fetching.interval}")
    public void matchCase() {
        final Match newMatch = matchRepository.fetchCasePairAsNewMatch();
        if (newMatch == null) {
            logger.debug("No cases for matching, query later...");
            try {
                Thread.sleep(sleepDuration);
            } catch (InterruptedException e) {
                logger.warn("Matching service sleep interupted!", e);
            }
        } else {
            final LostCase lostCase = caseRepository.getLostCaseById(newMatch.getLostId());
            final FindingCase findingCase = caseRepository.getFindingCaseById(newMatch.getFindingId());
            final MatchResult result = api.match(lostCase, findingCase);
            newMatch.setProbability(result.getProbability());
            matchRepository.saveMatch(newMatch);
            logger.debug("Match result: {}", newMatch);
        }
    }
}
