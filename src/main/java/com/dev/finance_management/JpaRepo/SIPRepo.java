package com.dev.finance_management.JpaRepo;

import com.dev.finance_management.Entities.Investment.Funds.SIPs;
import com.dev.finance_management.Entities.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SIPRepo extends JpaRepository<SIPs, Integer> {
    List<SIPs> getSIPsByUser(User user);
}
