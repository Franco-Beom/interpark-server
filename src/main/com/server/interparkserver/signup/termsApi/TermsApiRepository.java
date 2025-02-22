package com.server.interparkserver.signup.termsApi;

import com.server.interparkserver.termsApi.Terms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TermsApiRepository extends JpaRepository<Terms, Long> {
}