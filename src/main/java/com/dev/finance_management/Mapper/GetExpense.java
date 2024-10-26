package com.dev.finance_management.Mapper;

import java.util.Date;

public record GetExpense(
        Date date,
        String ledger,
        double amount,
        String description,
        String location
) {
}
