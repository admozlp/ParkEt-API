package com.ademozalp.ParkEt.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ademozalp.ParkEt.entities.concretes.Favori;

public interface FavoriRepository extends JpaRepository<Favori, Integer>{
	public boolean existsByAliciId(int id);
	public Favori findByAliciId(int id);
	
	public List<Favori> findAllByAliciId(int id);
	public List<Favori> findAllByOtoparkId(int id);
}
