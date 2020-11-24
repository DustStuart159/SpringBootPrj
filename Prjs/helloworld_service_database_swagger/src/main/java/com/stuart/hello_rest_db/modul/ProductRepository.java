package com.stuart.hello_rest_db.modul;

import com.stuart.hello_rest_db.modul.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ProductRepository extends JpaRepository<Product,Long> {
}
