package com.example.demo.repository;

import com.example.demo.models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Categories, Long> {

}
