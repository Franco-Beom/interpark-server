package com.server.interparkserver.signup.termsApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TermsApiController {

    @Autowired
    private TermsApiService termsApiService;

    @Autowired
    public TermsController(TermsApiService termsApiService) {
        this.termsApiService = termsApiService;
    }

    @GetMapping("/termsList")
    public List<TermsList> getTerms() {
        return termsApiService.getAllTerms();
    }
}
