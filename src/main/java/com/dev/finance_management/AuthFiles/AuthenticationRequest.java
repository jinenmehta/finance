package com.dev.finance_management.AuthFiles;

public record AuthenticationRequest(
        String email,
        String password
) {

}
