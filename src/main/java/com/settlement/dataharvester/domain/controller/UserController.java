package com.settlement.dataharvester.domain.controller;

import com.settlement.dataharvester.domain.dto.user.LoginForm;
import com.settlement.dataharvester.domain.dto.user.SignUpForm;
import com.settlement.dataharvester.domain.service.UserService;
import com.settlement.dataharvester.domain.session.RedisUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final RedisUserRepository redisUserRepository;


    @PostMapping("/signup")
    public void signup(@Validated @RequestBody SignUpForm signUpForm) {
        // ID 중복 검사
        if (userService.isDuplicatedId(signUpForm.getUsername())) {
            throw new IllegalArgumentException("사용할 수 없는 ID입니다.");
        }
        String encodedPassword = passwordEncoder.encode(signUpForm.getPassword());
        signUpForm.setEncodedPassword(encodedPassword);
        // Create user
        userService.createUser(signUpForm);
    }

    @PostMapping("/login")
    public boolean login(@Validated @RequestBody LoginForm loginForm) {
        // return LoginStatus(boolean)
        return userService.authenticateUser(loginForm);
    }

    @PostMapping("/logout")
    public void logout() {
        // TODO sessionId를 이용하여 삭제 (아직 미구현)
        UUID sessionId = UUID.randomUUID();
        // -----------------
        redisUserRepository.deleteById(sessionId);
        log.info("로그아웃");
    }
}
