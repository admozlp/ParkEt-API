package com.ademozalp.ParkEt.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ademozalp.ParkEt.business.abstracts.FavoriService;
import com.ademozalp.ParkEt.business.requests.CreateFavoriRequest;
import com.ademozalp.ParkEt.business.responses.GetAllFavoriResponse;
import com.ademozalp.ParkEt.business.responses.GetFavoriByAliciIdResponse;
import com.ademozalp.ParkEt.business.responses.GetFavoriByIdResponse;
import com.ademozalp.ParkEt.business.responses.GetFavoriByOtoparkIdResponse;
import com.ademozalp.ParkEt.business.rules.AliciBusinessRules;
import com.ademozalp.ParkEt.business.rules.FavoriBusinessRules;
import com.ademozalp.ParkEt.business.rules.OtoparkBusinessRules;
import com.ademozalp.ParkEt.core.utilities.mappers.satici.MapperService;
import com.ademozalp.ParkEt.dataAccess.abstracts.FavoriRepository;
import com.ademozalp.ParkEt.entities.concretes.Favori;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FavoriManager implements FavoriService{
	private FavoriRepository favoriRepository;
	private MapperService mapperService;
	private FavoriBusinessRules favoriBusinessRules;
	private AliciBusinessRules aliciBusinessRules;
	private OtoparkBusinessRules otoparkBusinessRules;

	@Override
	public void add(CreateFavoriRequest createFavoriRequest) {
		this.otoparkBusinessRules.existsById(createFavoriRequest.getOtoparkId());
		
		this.aliciBusinessRules.existsById(createFavoriRequest.getAliciId());
		
		this.favoriBusinessRules.checkExistsByAliciId(createFavoriRequest.getAliciId(), 
				createFavoriRequest.getOtoparkId());
		
		
		Favori favori = this.mapperService.forRequst()
				.map(createFavoriRequest, Favori.class);
		
		this.favoriRepository.save(favori);
		
	}

	@Override
	public List<GetAllFavoriResponse> getAll() {
		List<Favori> favoriler = this.favoriRepository.findAll();
		
		List<GetAllFavoriResponse> getAllFavoriRespons =
				favoriler.stream().map(favori -> 
				this.mapperService.forResponse()
				.map(favori, GetAllFavoriResponse.class))
				.collect(Collectors.toList());
				
		for(GetAllFavoriResponse get : getAllFavoriRespons) {
			for(Favori favori : favoriler) {
				get.setTarihSaat(favori.getDate().toString());
			}
		}
		
		return getAllFavoriRespons;
	}

	@Override
	public GetFavoriByIdResponse getById(int id) {
		this.favoriBusinessRules.existsById(id);
		
		Favori favori = this.favoriRepository.findById(id).get();
		
		GetFavoriByIdResponse getFavoriByIdResponse = 
				this.mapperService.forResponse()
				.map(favori, GetFavoriByIdResponse.class);
		
		
		getFavoriByIdResponse.setTarihSaat(favori.getDate().toString());
		return getFavoriByIdResponse;
	}

	@Override
	public List<GetFavoriByAliciIdResponse> getByAliciId(int id) {
		this.aliciBusinessRules.existsById(id);
		
		List<Favori> favoriler = this.favoriRepository.findAllByAliciId(id);
		
		List<GetFavoriByAliciIdResponse> getFavoriByAliciIdResponse =
				favoriler.stream().map(favori -> 
				this.mapperService.forResponse()
				.map(favori, GetFavoriByAliciIdResponse.class))
				.collect(Collectors.toList());
				
		for(GetFavoriByAliciIdResponse get : getFavoriByAliciIdResponse) {
			for(Favori favori : favoriler) {
				get.setTarihSaat(favori.getDate().toString());
			}
		}

		return getFavoriByAliciIdResponse;
	}

	@Override
	public List<GetFavoriByOtoparkIdResponse> getByOtoparkId(int id) {
		this.otoparkBusinessRules.existsById(id);
		
		List<Favori> favoriler = this.favoriRepository.findAllByOtoparkId(id);
		
		List<GetFavoriByOtoparkIdResponse> getFavoriByOtoparkIdResponses =
				favoriler.stream().map(favori -> 
				this.mapperService.forResponse()
				.map(favori, GetFavoriByOtoparkIdResponse.class))
				.collect(Collectors.toList());
				
		for(GetFavoriByOtoparkIdResponse get : getFavoriByOtoparkIdResponses) {
			for(Favori favori : favoriler) {
				get.setTarihSaat(favori.getDate().toString());
			}
		}

		return getFavoriByOtoparkIdResponses;
	}

	@Override
	public void delete(int id) {
		this.favoriBusinessRules.existsById(id);
		
		this.favoriRepository.deleteById(id);;
	}

}
