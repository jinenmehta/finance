package com.dev.finance_management.Exceptions;

import java.util.Date;

public record GetExpense(
        Date date,
        String ledger,
        double amount,
        String description,
        String location
) {
}
