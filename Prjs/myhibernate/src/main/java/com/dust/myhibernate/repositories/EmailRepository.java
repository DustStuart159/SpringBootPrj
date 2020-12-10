package com.dust.myhibernate.repositories;

import com.dust.myhibernate.entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
