package com.dev.finance_management.Mapper;

public record UpdateUser(
        String name,
        int age,
        String email,
        String employmentType,
        float annualIncome,
        Boolean haveDematAccount,
        String username
) {
}
