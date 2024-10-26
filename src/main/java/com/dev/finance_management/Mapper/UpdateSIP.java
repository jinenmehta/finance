package com.dev.finance_management.Mapper;

import java.util.Date;

public record UpdateSIP(
        String fund,
        double amount,
        Date startDate,
        Date endDate
) {
}
