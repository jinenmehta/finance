package com.dev.finance_management.JpaRepo;

import com.dev.finance_management.Entities.Expense.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepo extends JpaRepository<Expense, Integer> {
}
