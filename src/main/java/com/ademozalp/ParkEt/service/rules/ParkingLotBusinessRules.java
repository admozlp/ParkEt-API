package com.ademozalp.ParkEt.service.rules;

import org.springframework.stereotype.Service;

import com.ademozalp.ParkEt.exception.BusinessException;
import com.ademozalp.ParkEt.repository.ParkingLotRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ParkingLotBusinessRules {
	private ParkingLotRepository parkingLotRepository;
	
	public void existsByName(String name) {
		if(parkingLotRepository.existsByName(name)) {
			throw new BusinessException("İsim Mevcut");
		}
	}
	
	public void existsById(Long id) {
		if(!this.parkingLotRepository.existsById(id)) {
			throw new BusinessException("Otopark Mevcut Değil");
		}
	}
	
	public void existsBySaticiId(Long id) {
		if(!this.parkingLotRepository.existsBySellerId(id)) {
			throw new BusinessException("Satıcının İlanı Bulunmamakta");
		}
	}
	
	public void existsByPostaKoduId(Long id) {
		if(!this.parkingLotRepository.existsByPostalCodeId(id)) {
			throw new BusinessException("Bu Şehirde İlan Bulunmuyor");
		}
	}
	
	public void checkUcretGreaterThanZero(Double parkingFee) {
		if(parkingFee < 0) {
			throw new BusinessException("Fiyat 0'dan küçük olamaz");
		}
	}
	

}
