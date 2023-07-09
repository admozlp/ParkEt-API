package com.ademozalp.ParkEt.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ademozalp.ParkEt.entities.concretes.Alici;

public interface AliciRepository extends JpaRepository<Alici, Integer> {
	boolean existsByEmail(String email);
	Alici findByEmail(String email); 
}
