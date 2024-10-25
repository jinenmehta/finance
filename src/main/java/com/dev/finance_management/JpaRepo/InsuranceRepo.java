package com.dev.finance_management.JpaRepo;

import com.dev.finance_management.Entities.Insurance.Insurance;
import com.dev.finance_management.Entities.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InsuranceRepo extends JpaRepository<Insurance, Integer> {
    List<Insurance> findInsuranceByUser(User user);
    Insurance findInsuranceByInsuranceNumber(String insuranceNumber);
}
