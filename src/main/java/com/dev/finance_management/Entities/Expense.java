package com.dev.finance_management.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String description;
    @Column(nullable = false)
    private double amount;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private int ledgerId;
    private String location;
    @Column(nullable = false)
    private int userId;
}