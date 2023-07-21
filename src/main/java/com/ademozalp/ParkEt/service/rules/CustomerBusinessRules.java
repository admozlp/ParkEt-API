package com.ademozalp.ParkEt.service.rules;

import com.ademozalp.ParkEt.exception.BusinessException;
import com.ademozalp.ParkEt.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerBusinessRules {

    private final CustomerRepository customerRepository;

    public void existsByEmail(String email) {
        if (this.customerRepository.existsByEmail(email)) {
            throw new BusinessException("Email Mevcut");
        }
    }

    public void existsById(Long id) {
        if (!this.customerRepository.existsById(id)) {
            throw new BusinessException("Alici Mevcut Değil");
        }
    }

    public void checkMailExists(String mail) {
        if (!this.customerRepository.existsByEmail(mail)) {
            throw new BusinessException("Email Mevcut Değil");
        }
    }

    public void checkPass(String db, String client) {
        if (!db.equals(client)) {
            throw new BusinessException("Şifre Doğru Değil");
        }
    }

    public void checkPassEqueal(String yeniPass, String yeniPassTekrar) {
        if (!yeniPass.equals(yeniPassTekrar)) {
            throw new BusinessException("Parola Ve Parola Tekrarı Eşleşmiyor");
        }
    }
}
