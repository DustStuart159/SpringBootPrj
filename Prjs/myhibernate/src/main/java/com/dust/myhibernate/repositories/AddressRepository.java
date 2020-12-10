package com.dust.myhibernate.repositories;

import com.dust.myhibernate.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
