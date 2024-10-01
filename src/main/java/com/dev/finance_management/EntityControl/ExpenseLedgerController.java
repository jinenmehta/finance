package com.dev.finance_management.EntityControl;

import com.dev.finance_management.Entities.ExpenseLedger;
import com.dev.finance_management.JpaRepo.ExpenseLedgerRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expense/ledgers/")
@AllArgsConstructor
public class ExpenseLedgerController {
    private final ExpenseLedgerRepo expenseLedgerRepo;

    @PostMapping("add")
    public ExpenseLedger createExpenseLedger(@RequestBody ExpenseLedger expenseLedger) {
        return expenseLedgerRepo.save(expenseLedger);
    }
}
