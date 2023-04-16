package com.settlement.dataharvester.domain.service;

import com.settlement.dataharvester.domain.dto.user.LoginForm;
import com.settlement.dataharvester.domain.dto.user.SignUpForm;
import com.settlement.dataharvester.domain.entity.User;
import com.settlement.dataharvester.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UUID createUser(SignUpForm signUpForm) {
        User user = new User(signUpForm.getUsername(), signUpForm.getPassword(), signUpForm.getEmail(), signUpForm.getFullname());
        userRepository.save(user);
        return user.getId();
    }

    public boolean authenticateUser(LoginForm loginForm) {
        User findUser = userRepository.findByUsername(loginForm.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("ID 또는 Password가 일치하지 않습니다."));
        if (passwordEncoder.matches(loginForm.getPassword(), findUser.getPassword())) {
            // TODO 로그인 성공 처리
            log.info("[[로그인 성공]]");
            return true;
        }
        return false;
    }


    public boolean isDuplicatedId(String username) {
        return userRepository.existsByUsername(username);
    }
}
