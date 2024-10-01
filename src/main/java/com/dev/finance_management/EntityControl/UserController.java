package com.dev.finance_management.EntityControl;

import com.dev.finance_management.Entities.User;
import com.dev.finance_management.JpaRepo.UserRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController {
    private final UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("create")
    public User createUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    @PutMapping("update/{username}")
    public User updateUser(@RequestBody User user, @PathVariable String username) {
        User u = userRepo.findByUsername(username);
        if (u != null) {
            u.setAge(user.getAge());
            u.setEmail(user.getEmail());
            u.setName(user.getName());
            u.setPassword(user.getPassword());
            u.setAnnual_income(user.getAnnual_income());
            u.setUsername(user.getUsername());
            u.setEmployment_type(user.getEmployment_type());
            u.setHaveDematAccount(user.getHaveDematAccount());
            return userRepo.save(u);
        }
        else {
            return u;
        }
    }

    @DeleteMapping("delete/{username}")
    public void deleteUser(@PathVariable String username) {
        User u = userRepo.findByUsername(username);
        if (u != null) {
            userRepo.delete(u);
        }
    }

    @GetMapping("get/{username}")
    public User getUser(@PathVariable String username) {
        return userRepo.findByUsername(username);
    }

    @GetMapping("get/all")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping("getId/{username}")
    public int getId(@PathVariable String username) {
        return userRepo.findByUsername(username).getId();
    }

    @GetMapping("getMail/{username}")
    public String getEmail(@PathVariable String username) {
        return userRepo.findByUsername(username).getEmail();
    }

    @DeleteMapping("delete/all")
    public void clearDatabase() {
        userRepo.deleteAll();
    }
}
