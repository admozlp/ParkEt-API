package com.ademozalp.ParkEt.repository;

import com.ademozalp.ParkEt.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByEmail(String email);

    Customer findByEmail(String email);
}
