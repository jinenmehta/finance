package com.dev.finance_management.EntityControl;

import com.dev.finance_management.Entities.Expense;
import com.dev.finance_management.JpaRepo.ExpenseRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expense/")
@AllArgsConstructor
public class ExpenseController {

    private final ExpenseRepo expenseRepo;

    @PostMapping("add")
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseRepo.save(expense);
    }
}
