package com.example.demo.repository;

import com.example.demo.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Products, Long> {

}
