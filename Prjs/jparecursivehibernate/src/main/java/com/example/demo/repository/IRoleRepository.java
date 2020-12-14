package com.example.demo.repository;

import com.example.demo.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IRoleRepository extends JpaRepository<Roles, Long> {
}
