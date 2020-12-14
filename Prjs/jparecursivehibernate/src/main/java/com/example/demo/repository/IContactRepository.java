package com.example.demo.repository;

import com.example.demo.models.Accounts;
import com.example.demo.models.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContactRepository extends JpaRepository<Contacts, Long> {
}
