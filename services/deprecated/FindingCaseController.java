package com.epam.hackathon.web.controller;

import com.epam.hachathon.domain.FindingCase;
import com.epam.hackathon.data.CaseRepository;
import com.epam.hackathon.web.request.ConfirmMatchingRequest;
import com.epam.hackathon.web.request.LostMatchQueryRequest;
import com.epam.hackathon.web.response.FindingReportConfirm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(method = RequestMethod.POST)
class FindingCaseController {
    private final CaseRepository caseRepository;

    @Autowired
    FindingCaseController(final CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    @RequestMapping("/finding/report")
    public FindingReportConfirm reportFinding(@RequestBody final FindingCase reportRequest) {
        final long findingId = caseRepository.saveFindingCase(reportRequest);
        return new FindingReportConfirm(findingId);
    }

    @RequestMapping("/finding/match-detail")
    public List<FindingCase> queryMatchDetail(@RequestBody final LostMatchQueryRequest request) {
        return caseRepository.getFindingCases(request.getLostId());
    }

    @RequestMapping("/finding/confirm")
    public void confirmFinding(@RequestBody final ConfirmMatchingRequest confirmRequest) {
        caseRepository.confirmMatch(confirmRequest.getUserId(), confirmRequest.getLostId(), confirmRequest.getFindingId());
    }

}
