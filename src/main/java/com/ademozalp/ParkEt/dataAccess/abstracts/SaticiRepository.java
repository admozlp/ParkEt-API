package com.ademozalp.ParkEt.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ademozalp.ParkEt.entities.concretes.Satici;

public interface SaticiRepository extends JpaRepository<Satici, Integer>{
	boolean existsBytelefon(String telefon);
	Satici findByPass(String pass);

}
