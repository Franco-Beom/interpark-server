package com.server.interparkserver.signup.verifyCode;

import com.example.signup.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/verificationCode")
public class VerificationCodeController {

    private final VerificationCodeService verificationcodeService;

    @Autowired
    public VerificationController(VerificationCodeService verificationcodeService) {
        this.verificationcodeService = verificationcodeService;
    }

    // 인증번호 발송
    @PostMapping("/send")
    public ResponseEntity<String> sendVerificationCode(@RequestParam String email) {
        verificationcodeService.sendVerificationEmail(email);
        return ResponseEntity.ok("인증번호가 이메일로 발송되었습니다.");
    }

    // 인증번호 검증
    @PostMapping("/verify")
    public ResponseEntity<String> verifyVerificationCode(@RequestParam String email, @RequestParam String code) {
        boolean isValid = verificationcodeService.validateVerificationCode(email, code);
        if (isValid) {
            return ResponseEntity.ok("인증번호가 확인되었습니다.");
        } else {
            return ResponseEntity.status(400).body("인증번호가 유효하지 않거나 만료되었습니다.");
        }
    }
}