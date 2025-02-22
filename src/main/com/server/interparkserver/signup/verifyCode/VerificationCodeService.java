package com.server.interparkserver.signup.verifyCode;

import com.example.signup.verifyCode.VerificationCode;
import com.example.signup.verifyCode.VerificationCodeRepository;
import com.server.interparkserver.util.SendEmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class VerificationService {

    private final VerificationCodeRepository verificationCodeRepository;
    private final SendEmailUtil sendEmailUtil;

    @Autowired
    public VerificationService(VerificationCodeRepository verificationCodeRepository,  SendEmailUtil sendEmailUtil) {
        this.verificationCodeRepository = verificationCodeRepository;
        this.emailUtil = emailUtil;
    }

    public String generateVerificationCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000); // 6자리 인증번호
        return String.valueOf(code);
    }

    public void sendVerificationEmail(String email) {
        String code = generateVerificationCode();
        VerificationCode verificationCode = new VerificationCode();
        verificationCode.setEmail(email);
        verificationCode.setCode(code);

        verificationCodeRepository.save(verificationCode);

        // 이메일 전송
        emailUtil.sendEmail(email, "회원가입 인증번호", "인증번호: " + code);
    }

    public boolean validateVerificationCode(String email, String code) {
        VerificationCode verificationCode = verificationCodeRepository.findByEmail(email)
                .filter(vc -> vc.getCode().equals(code)) // 코드 일치 여부 확인
                .orElse(null);

        return verificationCode != null;
    }
}