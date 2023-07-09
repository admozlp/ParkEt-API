package com.ademozalp.ParkEt.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ademozalp.ParkEt.entities.concretes.PostaKodu;

public interface PostaKoduRepository extends JpaRepository<PostaKodu, Integer>{

}
