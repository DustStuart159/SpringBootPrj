package com.dust.myhibernate.repositories;

import com.dust.myhibernate.entities.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepository extends JpaRepository<Level, Long> {
}
