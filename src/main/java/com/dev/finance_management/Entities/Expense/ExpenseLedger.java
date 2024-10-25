package com.dev.finance_management.Entities.Expense;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class ExpenseLedger {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(nullable = false, unique = true)
    private String ledger;

    @OneToMany(mappedBy = "ledger")
    @JsonBackReference
    private List<Expense> expenses;
}
