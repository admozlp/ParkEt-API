package com.ademozalp.ParkEt.business.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ademozalp.ParkEt.core.utilities.exceptions.BusinessException;
import com.ademozalp.ParkEt.dataAccess.abstracts.AliciRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AliciBusinessRules {
	@Autowired
	private AliciRepository aliciRepository;
	
	public void existsByEmail(String email) {
		if(this.aliciRepository.existsByEmail(email)) {
			throw new BusinessException("Email Mevcut");
		}
	}
	
	public void existsById(int id) {
		if(!this.aliciRepository.existsById(id)) {
			throw new BusinessException("Alici Mevcut Değil");
		}
	}
	
	public void checkMailExists(String mail) {
		if(!this.aliciRepository.existsByEmail(mail)) {
			throw new BusinessException("Email Mevcut Değil");
		}
	}
	
	public void checkPass(String db, String client) {
		if(!db.equals(client)) {
			throw new BusinessException("Şifre Doğru Değil");
		}
	}
	
	public void checkPassEqueal(String yeniPass, String yeniPassTekrar) {
		if(!yeniPass.equals(yeniPassTekrar)) {
			throw new BusinessException("Parola Ve Parola Tekrarı Eşleşmiyor");
		}
	}
}
