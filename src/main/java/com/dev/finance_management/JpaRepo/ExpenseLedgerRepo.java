package com.dev.finance_management.JpaRepo;

import com.dev.finance_management.Entities.ExpenseLedger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseLedgerRepo extends JpaRepository<ExpenseLedger, Integer> {
    public ExpenseLedger findByLedger(String ledger);
}
