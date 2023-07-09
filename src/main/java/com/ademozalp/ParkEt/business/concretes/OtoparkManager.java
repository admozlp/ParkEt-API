package com.ademozalp.ParkEt.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ademozalp.ParkEt.business.abstracts.OtoparkService;
import com.ademozalp.ParkEt.business.requests.CreateOtoparkRequest;
import com.ademozalp.ParkEt.business.requests.UpdateOtoparkRequest;
import com.ademozalp.ParkEt.business.responses.GetAllOtoparkByPostaKodId;
import com.ademozalp.ParkEt.business.responses.GetAllOtoparkBySaticiId;
import com.ademozalp.ParkEt.business.responses.GetAllOtoparkKapasiteGreaterThanEqual;
import com.ademozalp.ParkEt.business.responses.GetAllOtoparkResponse;
import com.ademozalp.ParkEt.business.responses.GetByUcretLessThanEqual;
import com.ademozalp.ParkEt.business.responses.GetOtoparkById;
import com.ademozalp.ParkEt.business.rules.OtoparkBusinessRules;
import com.ademozalp.ParkEt.business.rules.SaticiBusinessRules;
import com.ademozalp.ParkEt.core.utilities.mappers.satici.MapperService;
import com.ademozalp.ParkEt.dataAccess.abstracts.OtoparkRepository;
import com.ademozalp.ParkEt.entities.concretes.Otopark;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OtoparkManager implements OtoparkService{
	private OtoparkRepository otoparkRepository;
	private OtoparkBusinessRules otoparkBusinessRules;
	private MapperService mapperService;
	private SaticiBusinessRules saticiBusinessRules;
	
	@Override
	public void add(CreateOtoparkRequest createOtoparkRequest) {
		this.otoparkBusinessRules.existsByName(createOtoparkRequest.getAdi());
		
		this.otoparkBusinessRules.checkUcretGreaterThanZero(createOtoparkRequest.getUcret());
		
		Otopark otopark = mapperService.forRequst().map(createOtoparkRequest, Otopark.class);
		
		this.otoparkRepository.save(otopark);
		
	}

	@Override
	public List<GetAllOtoparkResponse> getAllOtopark() {
		List<Otopark>otoparklar = otoparkRepository.findAll();
		
		List<GetAllOtoparkResponse> getAllOtoparkResponses = 
				otoparklar.stream().map(otopark->
				this.mapperService.forResponse().map
				(otopark, GetAllOtoparkResponse.class)).collect(Collectors.toList());
		
		return getAllOtoparkResponses;
	}

	@Override
	public GetOtoparkById getOtoparkById(int id) {
		this.otoparkBusinessRules.existsById(id);
		
		Otopark otopark = this.otoparkRepository.findById(id).get();
		
		GetOtoparkById getOtoparkById = this.mapperService.forResponse()
				.map(otopark, GetOtoparkById.class);
		
		return getOtoparkById;
	}

	@Override
	public List<GetAllOtoparkBySaticiId> getAllOtoparkBySaticiId(int id) {
		this.otoparkBusinessRules.existsBySaticiId(id);
		
		List<Otopark> otoparklar = this.otoparkRepository.findAllBySaticiId(id);
		
		List<GetAllOtoparkBySaticiId> allOtoparkBySaticiId = 
				otoparklar.stream().map(otopark -> 
				this.mapperService.forResponse()
				.map(otopark, GetAllOtoparkBySaticiId.class))
				.collect(Collectors.toList());
		
		return allOtoparkBySaticiId;
	}

	@Override
	public List<GetAllOtoparkByPostaKodId> getAllOtoparkByPostaKodId(int id) {
		this.otoparkBusinessRules.existsByPostaKoduId(id);
		
		List<Otopark> otoparklar = this.otoparkRepository.findAllByPostaKoduId(id);
		
		List<GetAllOtoparkByPostaKodId> allOtoparkByPostaKodId = 
				otoparklar.stream().map(otopark -> 
				this.mapperService.forResponse()
				.map(otopark, GetAllOtoparkByPostaKodId.class))
				.collect(Collectors.toList());
		
		return allOtoparkByPostaKodId;
	}

	@Override
	public List<GetAllOtoparkKapasiteGreaterThanEqual> getByKapasite(int kapasite) {
		List<Otopark> otoparklar = this.otoparkRepository.findAllByKapasiteGreaterThanEqual(kapasite);
		
		List<GetAllOtoparkKapasiteGreaterThanEqual> getAllOtoparkKapasiteGreaterThanEquals = 
				otoparklar.stream().map(otopark -> 
				this.mapperService.forResponse()
				.map(otopark, GetAllOtoparkKapasiteGreaterThanEqual.class))
				.collect(Collectors.toList());

		
		return getAllOtoparkKapasiteGreaterThanEquals;
	}

	@Override
	public List<GetByUcretLessThanEqual> getByUcret(double maxUcret) {
		this.otoparkBusinessRules.checkUcretGreaterThanZero(maxUcret);
		
		List<Otopark> otoparklar = 
				this.otoparkRepository.findAllByUcretLessThanEqual(maxUcret);
		
		List<GetByUcretLessThanEqual> getByUcretLessThanEquals = 
				otoparklar.stream().map(otopark -> 
				this.mapperService.forResponse()
				.map(otopark, GetByUcretLessThanEqual.class))
				.collect(Collectors.toList());
		
		return getByUcretLessThanEquals;
	}

	@Override
	public void delete(int id) {
		this.otoparkBusinessRules.existsById(id);
		
		this.otoparkRepository.deleteById(id);
	}

	@Override
	public void deleteBySaticiId(int id) {
		this.saticiBusinessRules.checkSaticisExists(id);
		
		this.otoparkBusinessRules.existsBySaticiId(id);
		
		this.otoparkRepository.deleteBySaticiId(id);
	}

	@Override
	public void update(UpdateOtoparkRequest updateOtoparkRequest) {
		this.otoparkBusinessRules.existsById(updateOtoparkRequest.getId());
		
		Otopark otopark = this.otoparkRepository.findById(updateOtoparkRequest.getId()).get();
		
		this.mapperService.forRequst()
				.map(updateOtoparkRequest, otopark);
		
		otopark.setSatici(updateOtoparkRequest.getSatici());
		otopark.setPostaKodu(updateOtoparkRequest.getPostaKodu());
		
		this.otoparkRepository.save(otopark);
		
	}
	

}
