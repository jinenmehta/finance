package com.dev.finance_management.EntityControl;

import com.dev.finance_management.Entities.User.User;
import com.dev.finance_management.Entities.User.EnumClass.Role;
import com.dev.finance_management.Mapper.GetUser;
import com.dev.finance_management.Mapper.RegisterRequest;
import com.dev.finance_management.Mapper.UpdateUser;
import com.dev.finance_management.JpaRepo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/")
@AllArgsConstructor
public class UserController {

    private final UserRepo userRepo;

    @GetMapping("get/{id}")
    public ResponseEntity<GetUser> getUserById(@PathVariable int id) {
        var user = userRepo.findById(id).orElseThrow();
        GetUser getUser = new GetUser(
                user.getId(),
                user.getName(),
                user.getAge(),
                user.getEmail(),
                user.getEmployment_type(),
                user.getAnnual_income(),
                user.getHaveDematAccount(),
                user.getUsername(),
                user.getRole().name()
        );
        return ResponseEntity.ok(getUser);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<UpdateUser> updateUser(@RequestBody UpdateUser updateUser, @PathVariable int id) {
        var user = userRepo.findById(id).orElseThrow();
        user.setName(updateUser.name());
        user.setAge(updateUser.age());
        user.setEmail(updateUser.email());
        user.setEmployment_type(updateUser.employmentType());
        user.setAnnual_income(updateUser.annualIncome());
        user.setHaveDematAccount(updateUser.haveDematAccount());
        user.setUsername(updateUser.username());
        userRepo.save(user);
        return ResponseEntity.ok(updateUser);
    }

    @PostMapping("create")
    public ResponseEntity<RegisterRequest> createUser(@RequestBody RegisterRequest createUser) {
        User user = new User();
        user.setName(createUser.name());
        user.setAge(createUser.age());
        user.setEmail(createUser.email());
        user.setEmployment_type(createUser.employmentType());
        user.setAnnual_income(createUser.annualIncome());
        user.setHaveDematAccount(createUser.haveDematAccount());
        user.setUsername(createUser.username());
        user.setPassword(createUser.password()); // Ensure password hashing if needed
        user.setRole(Role.valueOf(createUser.role()));
        userRepo.save(user);
        return ResponseEntity.ok(createUser);
    }
}
