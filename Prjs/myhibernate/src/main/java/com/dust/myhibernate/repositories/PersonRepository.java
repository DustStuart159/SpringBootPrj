package com.dust.myhibernate.repositories;

import com.dust.myhibernate.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PersonRepository extends JpaRepository<Person, Long> {
}
