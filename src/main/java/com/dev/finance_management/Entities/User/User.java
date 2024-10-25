package com.dev.finance_management.Entities.User;

import com.dev.finance_management.Entities.Expense.Expense;
import com.dev.finance_management.Entities.Insurance.Insurance;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Expense> expenses;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Insurance> insurances;
}
