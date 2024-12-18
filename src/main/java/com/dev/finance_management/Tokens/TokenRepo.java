package com.dev.finance_management.Tokens;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TokenRepo extends JpaRepository<Token, Integer> {
    @Query("""
SELECT t FROM Token t 
JOIN User u on t.user.id = u.id 
WHERE u.id = :userId and (t.isExpired = false or t.isRevoked = false)
""")
    List<Token> findValidTokensByUserId(@Param("userId") Integer userId);
    Optional<Token> findByToken(String token);
}
