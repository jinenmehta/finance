package com.dev.finance_management.Entities.User;

import com.dev.finance_management.Entities.Expense.Expense;
import com.dev.finance_management.Entities.Insurance.Insurance;
import com.dev.finance_management.Entities.Investment.Funds.SIPs;
import com.dev.finance_management.Entities.User.EnumClass.Role;
import com.dev.finance_management.Tokens.Token;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(nullable = false)
    private String name;

    private int age;
    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String employment_type;

    @Column(nullable = false)
    private float annual_income;

    @Column(nullable = false)
    private Boolean haveDematAccount;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Expense> expenses;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Insurance> insurances;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<SIPs> sips;

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }
}
