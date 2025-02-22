package com.server.interparkserver.signup.termsApi;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TermsApiService {

    private final TermsApiRepository termsApiRepository;

    @Autowired
    public TermsApiService(TermsApiRepository termsApiRepository) {
        this.termsApiRepository = termsApiRepository;
    }

    public List<Terms> getAllTerms() {
        return termsApiRepository.findAll();
    }
}
