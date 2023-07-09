package com.ademozalp.ParkEt.business.rules;

import org.springframework.stereotype.Service;

import com.ademozalp.ParkEt.core.utilities.exceptions.BusinessException;
import com.ademozalp.ParkEt.dataAccess.abstracts.OtoparkRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OtoparkBusinessRules {
	private OtoparkRepository otoparkRepository;
	
	public void existsByName(String name) {
		if(otoparkRepository.existsByadi(name)) {
			throw new BusinessException("İsim Mevcut");
		}
	}
	
	public void existsById(int id) {
		if(!this.otoparkRepository.existsById(id)) {
			throw new BusinessException("Otopark Mevcut Değil");
		}
	}
	
	public void existsBySaticiId(int id) {
		if(!this.otoparkRepository.existsBySaticiId(id)) {
			throw new BusinessException("Satıcının İlanı Bulunmamakta");
		}
	}
	
	public void existsByPostaKoduId(int id) {
		if(!this.otoparkRepository.existsByPostaKoduId(id)) {
			throw new BusinessException("Bu Şehirde İlan Bulunmuyor");
		}
	}
	
	public void checkUcretGreaterThanZero(double ucret) {
		if(ucret < 0) {
			throw new BusinessException("Fiyat 0 dan küçük olamaz");
		}
	}
	

}
