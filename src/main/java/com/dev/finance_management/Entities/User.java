package com.dev.finance_management.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(nullable = false)
    private String name;
    private int age;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String employment_type;
    @Column(nullable = false)
    private float annual_income;
    @Column(nullable = false)
    private Boolean haveDematAccount;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
}
