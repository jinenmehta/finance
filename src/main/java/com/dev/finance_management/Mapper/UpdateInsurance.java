package com.dev.finance_management.Mapper;

import com.dev.finance_management.Entities.Insurance.EnumClass.InsuranceType;
import com.dev.finance_management.Entities.Insurance.EnumClass.PaymentTerm;

import java.util.Date;

public record UpdateInsurance(
        double premium,
        Date dateOfIssue,
        Date dateOfMaturity,
        Date dateOfLastPremium,
        String schemeName,
        String insuranceNumber,
        String insuranceCompany,
        PaymentTerm paymentTerm,
        InsuranceType insuranceType,
        String description,
        String agent

) {
}
