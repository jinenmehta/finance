package com.dev.finance_management.Tokens;

import com.dev.finance_management.Entities.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Token {
    @Id
    @GeneratedValue
    private int id;
    private String token;
    private TokenType tokenType;
    private boolean isExpired;
    private boolean isRevoked;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
