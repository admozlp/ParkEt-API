package com.ademozalp.ParkEt.service.rules;

import org.springframework.stereotype.Service;

import com.ademozalp.ParkEt.exception.BusinessException;
import com.ademozalp.ParkEt.repository.SellerRepository;
import com.ademozalp.ParkEt.model.Seller;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SellerBusinessRules {
	private SellerRepository sellerRepository;
	
	public void checkIfTelExists(String tel) {
		if(sellerRepository.existsByTelephone(tel)) {
			throw new BusinessException("Telefon Mevcut");
		}
	}
	
	public void checkSaticisExists(Long id) {
		if(!sellerRepository.existsById(id)) {
			throw new BusinessException("Satıcı Mevcut Değil");
		}
	}
	
	
	public void checkPass(String pass, Long id) {
		Seller seller = sellerRepository.findById(id).get();
		
		String dbPass = seller.getPassword();
		
		if(!dbPass.equals(pass)) {
			throw new BusinessException("Parola Doğru Depil");
		}
	}
	
	public void checkPassEquals(String pass, String passTekrar) {
		if(!pass.equals(passTekrar)) {
			throw new BusinessException("Parola Ve Parola Tekrar Aynı değil");
		}
	}

}
