package com.ademozalp.ParkEt.business.concretes;

import org.springframework.stereotype.Service;

import com.ademozalp.ParkEt.business.abstracts.PostaKoduService;
import com.ademozalp.ParkEt.dataAccess.abstracts.PostaKoduRepository;
import com.ademozalp.ParkEt.entities.concretes.PostaKodu;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostaKoduManager implements PostaKoduService{
	private PostaKoduRepository koduRepository;
	@Override
	public void add(PostaKodu kodu) {
		koduRepository.save(kodu);
	}

}
