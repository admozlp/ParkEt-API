package com.ademozalp.ParkEt.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ademozalp.ParkEt.business.abstracts.AliciService;
import com.ademozalp.ParkEt.business.requests.CreateAliciRequest;
import com.ademozalp.ParkEt.business.requests.UpdateAliciPassRequest;
import com.ademozalp.ParkEt.business.requests.UpdateAliciRequest;
import com.ademozalp.ParkEt.business.responses.GetAliciByEmailResponse;
import com.ademozalp.ParkEt.business.responses.GetAliciByIdResponse;
import com.ademozalp.ParkEt.business.responses.GetAllAliciResponse;
import com.ademozalp.ParkEt.business.rules.AliciBusinessRules;
import com.ademozalp.ParkEt.core.utilities.mappers.satici.MapperService;
import com.ademozalp.ParkEt.dataAccess.abstracts.AliciRepository;
import com.ademozalp.ParkEt.entities.concretes.Alici;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AliciManager implements AliciService {
	@Autowired
	private AliciRepository aliciRepository;
	private AliciBusinessRules aliciBusinessRules;
	private MapperService mapperService;
	
	@Override
	public void add(CreateAliciRequest createAliciRequest) {
		this.aliciBusinessRules.existsByEmail(createAliciRequest.getEmail());
		
		Alici alici = this.mapperService.forRequst()
				.map(createAliciRequest, Alici.class);
		
		this.aliciRepository.save(alici);
	}

	@Override
	public List<GetAllAliciResponse> getAllAlici() {
		List<Alici> alicilar = this.aliciRepository.findAll();
		
		List<GetAllAliciResponse> getAllAliciResponses = 
				alicilar.stream().map(alici->
				this.mapperService.forResponse()
				.map(alici, GetAllAliciResponse.class))
				.collect(Collectors.toList());
		
		return getAllAliciResponses;
		 
	}

	@Override
	public GetAliciByIdResponse getAliciById(int id) {
		this.aliciBusinessRules.existsById(id);
		
		Alici alici = this.aliciRepository.findById(id).get();
		
		GetAliciByIdResponse getAliciByIdResponse = 
				this.mapperService.forResponse()
				.map(alici, GetAliciByIdResponse.class);
		
		return getAliciByIdResponse;
	}

	@Override
	public GetAliciByEmailResponse getAliciByEmail(String email) {
		this.aliciBusinessRules.checkMailExists(email);
		
		Alici alici = this.aliciRepository.findByEmail(email);
		
		GetAliciByEmailResponse getAliciByEmailResponse = 
				this.mapperService.forResponse()
				.map(alici, GetAliciByEmailResponse.class);
		
		return getAliciByEmailResponse;
	}

	@Override
	public void delete(int id) {
		this.aliciBusinessRules.existsById(id);
		
		this.aliciRepository.deleteById(id);
	}

	@Override
	public void update(UpdateAliciRequest updateAliciRequest) {
		this.aliciBusinessRules.existsById(updateAliciRequest.getId());
		
		Alici alici = this.aliciRepository.findById(updateAliciRequest.getId()).get();
		
		this.aliciBusinessRules.checkPass(updateAliciRequest.getPass(), alici.getPass());
		
		this.mapperService.forRequst().map(updateAliciRequest, alici);
		
		this.aliciRepository.save(alici);
	}

	@Override
	public void updatePass(UpdateAliciPassRequest aliciPassRequest) {
		this.aliciBusinessRules.existsById(aliciPassRequest.getId());
		
		Alici alici = this.aliciRepository.findById(aliciPassRequest.getId()).get();
		
		this.aliciBusinessRules.checkPass(alici.getPass(), aliciPassRequest.getPass());
		
		this.aliciBusinessRules.checkPassEqueal(aliciPassRequest.getYeniPass(), aliciPassRequest.getYeniPassTekrar());
		
		alici.setPass(aliciPassRequest.getYeniPass());
		
		this.aliciRepository.save(alici);
	}

}
