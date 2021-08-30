package com.example.shepherd.repos;

import java.util.Optional;

import com.example.shepherd.models.Account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {
    Optional<Account> findByEmailAddress (String emailAddress);
}
