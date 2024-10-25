package com.dev.finance_management.JpaRepo;

import com.dev.finance_management.Entities.Insurance.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepo extends JpaRepository<Insurance, Integer> {
}
