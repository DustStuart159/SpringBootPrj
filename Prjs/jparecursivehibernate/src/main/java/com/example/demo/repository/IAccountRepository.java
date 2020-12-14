package com.example.demo.repository;

import com.example.demo.models.Accounts;
import com.example.demo.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Accounts, Long> {
}
