package com.dev.finance_management.Mapper;

public record GetUser(
        int id,
        String name,
        int age,
        String email,
        String employment_type,
        float annual_income,
        Boolean haveDematAccount,
        String username,
        String role
) {
}
