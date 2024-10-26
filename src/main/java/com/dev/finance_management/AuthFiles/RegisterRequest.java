package com.dev.finance_management.AuthFiles;

public record RegisterRequest(
        String name,
        String email,
        String username,
        String password
) {
}
