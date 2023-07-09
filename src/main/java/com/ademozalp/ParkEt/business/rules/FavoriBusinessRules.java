package com.ademozalp.ParkEt.business.rules;

import org.springframework.stereotype.Service;

import com.ademozalp.ParkEt.core.utilities.exceptions.BusinessException;
import com.ademozalp.ParkEt.dataAccess.abstracts.FavoriRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FavoriBusinessRules {
	private FavoriRepository favoriRepository;
	
	public void checkExistsByAliciId(int aliciId, int otoId) {
		if(this.favoriRepository.existsByAliciId(aliciId)) {
			int otoparkId = this.favoriRepository.findByAliciId(aliciId).getOtopark().getId();
			if(otoId == otoparkId) {
				throw new BusinessException("Kayıt Mevcut");
			}
		}
	}
	
	public void existsById(int id) {
		if(!this.favoriRepository.existsById(id)) {
			throw new BusinessException("Favori Mevcut Değil");
		}
	}
}
