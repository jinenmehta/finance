package com.dev.finance_management.AuthFiles;

import com.dev.finance_management.Configuration.JWTService;
import com.dev.finance_management.Entities.User.EnumClass.Role;
import com.dev.finance_management.Entities.User.User;
import com.dev.finance_management.JpaRepo.UserRepo;
import com.dev.finance_management.Mapper.RegisterRequest;
import com.dev.finance_management.Tokens.Token;
import com.dev.finance_management.Tokens.TokenRepo;
import com.dev.finance_management.Tokens.TokenType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    private final TokenRepo tokenRepo;


    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = User.builder()
                .name(registerRequest.name())
                .email(registerRequest.email())
                .username(registerRequest.username())
                .password(passwordEncoder.encode(registerRequest.password()))
                .role(Role.USER)
                .build();
        userRepo.save(user);
        var jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.email(),
                            authRequest.password()
                    )
            );
            System.out.println("Hello");
            var user = userRepo.findByEmail(authRequest.email()).orElseThrow(() ->  new UsernameNotFoundException("userNotFound"));
            System.out.println(user);
            var jwtToken = jwtService.generateToken(user);
            revokeAllUserToken(user);
            saveUserToken(user, jwtToken);
            return new AuthenticationResponse(jwtToken);
        } catch (BadCredentialsException e) {
            return new AuthenticationResponse(e.getMessage());
        }
    }

    private void saveUserToken (User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .isExpired(false)
                .isRevoked(false)
                .build();
        tokenRepo.save(token);
    }

    private void revokeAllUserToken (User user) {
        var validUserToken = tokenRepo.findValidTokensByUserId(user.getId());
        if (validUserToken.isEmpty()) {
            return;
        }
        validUserToken.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepo.saveAll(validUserToken);
    }
}
