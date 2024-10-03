package com.dev.finance_management.EntityControl;

import com.dev.finance_management.Entities.ExpenseLedger;
import com.dev.finance_management.JpaRepo.ExpenseLedgerRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/expense/ledgers/")
@AllArgsConstructor
public class ExpenseLedgerController {
    private final ExpenseLedgerRepo expenseLedgerRepo;

    @PostMapping("add")
    public ExpenseLedger createExpenseLedger(@RequestBody ExpenseLedger expenseLedger) {
        return expenseLedgerRepo.save(expenseLedger);
    }

    @GetMapping("get/all/json")
    public Map<String, String> findAllAsJson() {
        List<ExpenseLedger> e = expenseLedgerRepo.findAll();
        Map<String, String> ledgers = new HashMap<String, String>();
        for (ExpenseLedger exp : e) {
            ledgers.put(exp.getLedger(), exp.getLedger());
        }
        return ledgers;
    }
}
