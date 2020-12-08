package com.stuart.hello_rest_db.modul;

import com.stuart.hello_rest_db.modul.Entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
