package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IInfoRepository extends JpaRepository<Info, Long> {
}
