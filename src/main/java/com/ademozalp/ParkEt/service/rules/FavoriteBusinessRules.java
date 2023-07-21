package com.ademozalp.ParkEt.service.rules;

import org.springframework.stereotype.Service;

import com.ademozalp.ParkEt.exception.BusinessException;
import com.ademozalp.ParkEt.repository.FavoriteRepository;

import lombok.AllArgsConstructor;

import java.util.Objects;

@Service
@AllArgsConstructor
public class FavoriteBusinessRules {
	private FavoriteRepository favoriteRepository;
	
	public void checkExistsByAliciId(Long customerId, Long parkingLotId) {
		if(this.favoriteRepository.existsByCustomerId(customerId)) {
			Long parkingLotId_ = this.favoriteRepository.findByCustomerId(customerId).getParkingLot().getId();
			if(Objects.equals(parkingLotId, parkingLotId_)) {
				throw new BusinessException("Kayıt Mevcut");
			}
		}
	}
	
	public void existsById(Long id) {
		if(!this.favoriteRepository.existsById(id)) {
			throw new BusinessException("Favori Mevcut Değil");
		}
	}
}
