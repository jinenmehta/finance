package com.dev.finance_management.Entities.Insurance;

import com.dev.finance_management.Entities.Insurance.EnumClass.InsuranceType;
import com.dev.finance_management.Entities.Insurance.EnumClass.PaymentTerm;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(nullable = false)
    private double premium;

    @Column(nullable = false)
    private InsuranceType insuranceType;

    @Column(nullable = false)
    private String insuranceCompany;

    private String agent;

    @Column(nullable = false)
    private String schemeName;

    private String description;

    @Column(nullable = false)
    private String insuranceNumber;

    @Column(nullable = false)
    private Date dateOfIssue;

    @Column(nullable = false)
    private Date dateOfMaturity;

    @Column(nullable = false)
    private Date dateOfLastPremium;

    @Column(nullable = false)
    private PaymentTerm paymentTerm;
}
