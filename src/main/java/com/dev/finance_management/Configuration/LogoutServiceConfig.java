package com.dev.finance_management.Configuration;

import com.dev.finance_management.Tokens.TokenRepo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogoutServiceConfig implements LogoutHandler {
    private final TokenRepo tokenRepo;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        final var authHeader = request.getHeader("Authorization");
        final String JWT;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        JWT = authHeader.substring(7);
        final var storedToken = tokenRepo.findByToken(JWT).orElse(null);
        if (storedToken != null) {
            storedToken.setExpired(true);
            storedToken.setRevoked(true);
            tokenRepo.save(storedToken);
        }
    }
}
