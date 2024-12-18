package com.dev.finance_management.Mapper;

public record RegisterRequest(
        String name,
        int age,
        String email,
        String employmentType,
        float annualIncome,
        Boolean haveDematAccount,
        String username,
        String password,
        String role
) {
}
