package com.ademozalp.ParkEt.repository;

import com.ademozalp.ParkEt.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long>{
	boolean existsByTelephone(String telephone);
}
