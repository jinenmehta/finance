package com.dev.finance_management.Mapper;

import java.util.Date;

public record UpdateExpense(
        double amount,
        String description,
        Date date
) {

}
