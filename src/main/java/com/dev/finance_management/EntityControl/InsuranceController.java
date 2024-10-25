package com.dev.finance_management.EntityControl;

import com.dev.finance_management.Entities.Insurance.Insurance;
import com.dev.finance_management.Entities.User.User;
import com.dev.finance_management.JpaRepo.InsuranceRepo;
import com.dev.finance_management.Mapper.UpdateInsurance;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insure/")
@AllArgsConstructor
public class InsuranceController {
    private final InsuranceRepo insuranceRepo;

    @PostMapping("add")
    public Insurance createInsurance(@RequestBody Insurance insurance) {
        return insuranceRepo.save(insurance);
    }

    @PutMapping("Update/{id}")
    public ResponseEntity<UpdateInsurance> updateInsurance(@PathVariable int id, @RequestBody UpdateInsurance updateInsurance) {
        var insurance = insuranceRepo.findById(id).get();
        insurance.setDescription(updateInsurance.description());
        insurance.setInsuranceType(updateInsurance.insuranceType());
        insurance.setInsuranceCompany(updateInsurance.insuranceCompany());
        insurance.setInsuranceNumber(updateInsurance.insuranceNumber());
        insurance.setAgent(updateInsurance.agent());
        insurance.setDateOfIssue(updateInsurance.dateOfIssue());
        insurance.setDateOfMaturity(updateInsurance.dateOfMaturity());
        insurance.setDateOfLastPremium(updateInsurance.dateOfLastPremium());
        insurance.setSchemeName(updateInsurance.schemeName());
        insurance.setPaymentTerm(updateInsurance.paymentTerm());
        insuranceRepo.save(insurance);
        return ResponseEntity.ok(updateInsurance);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Insurance> getInsurance(@PathVariable int id) {
        var insurance = insuranceRepo.findById(id).get();
        return ResponseEntity.ok(insurance);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Insurance> deleteInsurance(@PathVariable int id) {
        var insurance = insuranceRepo.findById(id).get();
        insuranceRepo.delete(insurance);
        return ResponseEntity.ok(insurance);
    }

    @GetMapping("get/byinsNum/{insuranceNumber}")
    public ResponseEntity<Insurance> getInsuranceByInsNum(@PathVariable String insuranceNumber) {
        var insurance = insuranceRepo.findInsuranceByInsuranceNumber(insuranceNumber);
        return ResponseEntity.ok(insurance);
    }

    @GetMapping("get/byUser/{user}")
    public List<Insurance> getInsuranceByUser(@PathVariable User user) {
        var insurance = insuranceRepo.findInsuranceByUser(user);
        return insurance;
    }
}
