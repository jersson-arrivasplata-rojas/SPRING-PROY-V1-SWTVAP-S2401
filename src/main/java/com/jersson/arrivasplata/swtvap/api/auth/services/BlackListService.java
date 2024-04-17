package com.jersson.arrivasplata.swtvap.api.auth.services;

import java.time.Instant;

import org.springframework.stereotype.Service;

import com.jersson.arrivasplata.swtvap.api.auth.model.BlacklistedToken;
import com.jersson.arrivasplata.swtvap.api.auth.repository.BlacklistedTokenRepository;

@Service
public class BlackListService {
    private BlacklistedTokenRepository blacklistedTokenRepository;

    public BlackListService(BlacklistedTokenRepository blacklistedTokenRepository) {
        this.blacklistedTokenRepository = blacklistedTokenRepository;
    }

    public void add(String token, Instant expiry) {
        BlacklistedToken blacklistedToken = new BlacklistedToken();
        blacklistedToken.setToken(token);
        blacklistedToken.setExpiry(expiry);
        blacklistedTokenRepository.save(blacklistedToken);
    }

    public boolean isBlacklisted(String token) {
        return blacklistedTokenRepository.findById(token).isPresent();
    }
}
