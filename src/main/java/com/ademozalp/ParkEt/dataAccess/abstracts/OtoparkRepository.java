package com.ademozalp.ParkEt.dataAccess.abstracts;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ademozalp.ParkEt.entities.concretes.Otopark;

public interface OtoparkRepository extends JpaRepository<Otopark, Integer>{
	boolean existsByadi(String adi);
	List<Otopark> findAllBySaticiId(int id);
	boolean existsBySaticiId(int id);
	List<Otopark> findAllByPostaKoduId(int id);
	boolean existsByPostaKoduId(int id);

	List<Otopark> findAllByKapasiteGreaterThanEqual(int kapasite);
	List<Otopark> findAllByUcretLessThanEqual(double ucret);
	
	void deleteById(int id);
	@Transactional
	void deleteBySaticiId(@Param("satici") int satici);
	
}
