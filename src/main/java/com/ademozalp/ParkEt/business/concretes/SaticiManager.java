package com.ademozalp.ParkEt.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ademozalp.ParkEt.business.abstracts.SaticiService;
import com.ademozalp.ParkEt.business.requests.CreateSaticiRequest;
import com.ademozalp.ParkEt.business.requests.UpdateSaticiPassRequest;
import com.ademozalp.ParkEt.business.requests.UpdateSaticiRequest;
import com.ademozalp.ParkEt.business.responses.GetAllSaticiResponse;
import com.ademozalp.ParkEt.business.responses.GetSaticiById;
import com.ademozalp.ParkEt.business.rules.SaticiBusinessRules;
import com.ademozalp.ParkEt.core.utilities.mappers.satici.MapperService;
import com.ademozalp.ParkEt.dataAccess.abstracts.SaticiRepository;
import com.ademozalp.ParkEt.entities.concretes.Satici;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SaticiManager implements SaticiService{
	@Autowired
	private SaticiRepository saticiRepository;
	@Autowired
	private MapperService saticiMapper;
	
	private SaticiBusinessRules saticiBusinessRules;
	

	@Override
	public void add(CreateSaticiRequest createSaticiRequest) {
		this.saticiBusinessRules.checkIfTelExists(createSaticiRequest.getTelefon());
		
		Satici satici =  this.saticiMapper.forRequst().map(createSaticiRequest, Satici.class);
		
		this.saticiRepository.save(satici);
	}

	@Override
	public List<GetAllSaticiResponse> getAll() {
		List<Satici> saticilar = saticiRepository.findAll();
		
		List<GetAllSaticiResponse> getAllSaticiResponses = 
				saticilar.stream().map(satici -> saticiMapper.forResponse()
						.map(satici, GetAllSaticiResponse.class)).collect(Collectors.toList());
		
		return getAllSaticiResponses;
	}

	@Override
	public GetSaticiById getSaticiById(int id) {
		this.saticiBusinessRules.checkSaticisExists(id);
		
		Satici satici = saticiRepository.findById(id).get();
		
		GetSaticiById getSaticiById = saticiMapper.forResponse().map(satici, GetSaticiById.class);
		
		return getSaticiById;
	}

	@Override
	public void delete(int id) {
		this.saticiBusinessRules.checkSaticisExists(id);
		
		saticiRepository.deleteById(id);
	}

	@Override
	public void update(UpdateSaticiRequest updateSaticiRequest) {
		this.saticiBusinessRules.checkSaticisExists(updateSaticiRequest.getId());
		
		this.saticiBusinessRules.checkPass(updateSaticiRequest.getPass(), updateSaticiRequest.getId());
		
		Satici satici = this.saticiMapper.forRequst().map(updateSaticiRequest, Satici.class);
		
		this.saticiRepository.save(satici);
	}

	@Override
	public void updatePass(UpdateSaticiPassRequest updateSaticiPassRequest) {
		this.saticiBusinessRules.checkSaticisExists(updateSaticiPassRequest.getId());
		
		this.saticiBusinessRules.checkPass(updateSaticiPassRequest.getEskiPass(), updateSaticiPassRequest.getId());
		
		this.saticiBusinessRules.checkPassEquals(updateSaticiPassRequest.getYeniPass(), updateSaticiPassRequest.getYeniPassTekrar());
		
		Satici satici = this.saticiRepository.findById(updateSaticiPassRequest.getId()).get();
		
		satici.setPass(updateSaticiPassRequest.getYeniPass());
		
		this.saticiRepository.save(satici);
	}

}
