package com.dust.myhibernate.repositories;


import com.dust.myhibernate.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PhoneRepository extends JpaRepository<Phone, Long> {
}