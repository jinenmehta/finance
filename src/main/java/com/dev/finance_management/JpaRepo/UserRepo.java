package com.dev.finance_management.JpaRepo;

import com.dev.finance_management.Entities.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
