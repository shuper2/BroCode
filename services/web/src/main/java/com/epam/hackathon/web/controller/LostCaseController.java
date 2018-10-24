package com.epam.hackathon.web.controller;

import com.epam.hachathon.domain.LostCase;
import com.epam.hackathon.data.CaseRepository;
import com.epam.hackathon.data.Preference;
import com.epam.hackathon.web.request.LostQueryRequest;
import com.epam.hackathon.web.request.UserLostQueryRequest;
import com.epam.hackathon.web.response.LostPublishConfirm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(method = RequestMethod.POST)
class LostCaseController {

    private final CaseRepository lostCaseRepository;

    @Autowired
    LostCaseController(final CaseRepository caseRepository) {
        this.lostCaseRepository = caseRepository;
    }

    @RequestMapping("/lost/publish")
    public LostPublishConfirm publishLost(@RequestBody final LostCase lostCase) {
        final long lostId = lostCaseRepository.saveLostCase(lostCase);
        return new LostPublishConfirm(lostId);
    }

    @RequestMapping("/lost/query")
    public List<LostCase> queryLost(@RequestBody final LostQueryRequest queryRequest) {
        return lostCaseRepository.fetchLostCasesByPreference(mapPreference(queryRequest));
    }

    @RequestMapping("/lost/query-my")
    public List<LostCase> queryMyLost(@RequestBody final UserLostQueryRequest queryRequest) {
        return lostCaseRepository.fetchUserLostCases(queryRequest.getUserId(), queryRequest.getPageNum());
    }

    private static Preference mapPreference(final LostQueryRequest queryRequest){
        throw new AssertionError("implement me!");
    }
}
