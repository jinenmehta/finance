package com.dev.finance_management.EntityControl;

import com.dev.finance_management.Entities.Expense;
import com.dev.finance_management.Exceptions.GetExpense;
import com.dev.finance_management.JpaRepo.ExpenseLedgerRepo;
import com.dev.finance_management.JpaRepo.ExpenseRepo;
import com.dev.finance_management.Mapper.UpdateExpense;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expense/")
@AllArgsConstructor
public class ExpenseController {

    private final ExpenseRepo expenseRepo;

    @PostMapping("add")
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseRepo.save(expense);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<UpdateExpense> updateExpense(@RequestBody UpdateExpense updateExpense, @PathVariable int id) {
        var expense = expenseRepo.findById(id).get();
        expense.setAmount(updateExpense.amount());
        expense.setDescription(updateExpense.description());
        expense.setDate(updateExpense.date());
        expenseRepo.save(expense);
        return ResponseEntity.ok(updateExpense);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<GetExpense> getExpenseById(@PathVariable int id) {
        var expense = expenseRepo.findById(id).get();
        GetExpense getExpense = new GetExpense(expense.getDate(), expense.getLedger().getLedger(), expense.getAmount(), expense.getDescription(), expense.getLocation());
        return ResponseEntity.ok(getExpense);
    }
}
