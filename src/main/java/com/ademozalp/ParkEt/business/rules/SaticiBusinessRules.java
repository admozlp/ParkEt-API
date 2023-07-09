package com.ademozalp.ParkEt.business.rules;

import org.springframework.stereotype.Service;

import com.ademozalp.ParkEt.core.utilities.exceptions.BusinessException;
import com.ademozalp.ParkEt.dataAccess.abstracts.SaticiRepository;
import com.ademozalp.ParkEt.entities.concretes.Satici;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SaticiBusinessRules {
	private SaticiRepository saticiRepository;
	
	public void checkIfTelExists(String tel) {
		if(saticiRepository.existsBytelefon(tel)) {
			throw new BusinessException("Telefon Mevcut");
		}
	}
	
	public void checkSaticisExists(int id) {
		if(!saticiRepository.existsById(id)) {
			throw new BusinessException("Satıcı Mevcut Değil");
		}
	}
	
	
	public void checkPass(String pass, int id) {
		Satici satici = saticiRepository.findById(id).get();
		
		String dbPass = satici.getPass();
		
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
