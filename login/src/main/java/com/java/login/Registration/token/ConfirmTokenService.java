package com.java.login.Registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmTokenService {
    private final ConfirmTokenRepository confirmTokenRepository;

    public void saveConfirmToken (ConfirmToken token){
        confirmTokenRepository.save(token);
    }

    public Optional<ConfirmToken> getToken(String token) {
        return confirmTokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return confirmTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
