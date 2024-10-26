package com.dev.finance_management.EntityControl;

import com.dev.finance_management.Entities.Investment.Funds.SIPs;
import com.dev.finance_management.Entities.User.User;
import com.dev.finance_management.JpaRepo.SIPRepo;
import com.dev.finance_management.Mapper.UpdateSIP;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/SIP/")
@AllArgsConstructor
public class SIPController {
    private final SIPRepo sipRepo;

    @PostMapping("add")
    private SIPs add(@RequestBody SIPs sip) {
        return sipRepo.save(sip);
    }

    @PutMapping("update/{id}")
    private ResponseEntity<UpdateSIP> updateSIP(@PathVariable int id, @RequestBody UpdateSIP updateSIP) {
        var sip = sipRepo.findById(id).get();
        sip.setAmount(updateSIP.amount());
        sip.setFund(updateSIP.fund());
        sip.setStartDate(updateSIP.startDate());
        sip.setEndDate(updateSIP.endDate());
        sipRepo.save(sip);
        return ResponseEntity.ok(updateSIP);
    }

    @GetMapping("get/{id}")
    private ResponseEntity<SIPs> getSIP(@PathVariable int id) {
        var sip = sipRepo.findById(id).get();
        return ResponseEntity.ok(sip);
    }

    @GetMapping("get/byUser/{user}")
    private List<SIPs> getSIPByUser(@PathVariable User user) {
        var sips = sipRepo.getSIPsByUser(user);
        return sips;
    }

    @DeleteMapping("delete/{id}")
    public String deleteSIP(@PathVariable int id) {
        var sip = sipRepo.findById(id).get();
        sipRepo.delete(sip);
        return "SIP deleted";
    }
}
