package com.ademozalp.ParkEt.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ademozalp.ParkEt.business.abstracts.FavoriService;
import com.ademozalp.ParkEt.business.requests.CreateFavoriRequest;
import com.ademozalp.ParkEt.business.responses.GetAllFavoriResponse;
import com.ademozalp.ParkEt.business.responses.GetFavoriByAliciIdResponse;
import com.ademozalp.ParkEt.business.responses.GetFavoriByIdResponse;
import com.ademozalp.ParkEt.business.responses.GetFavoriByOtoparkIdResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/favoriler")
@AllArgsConstructor
public class FavoriController {
	@Autowired
	private FavoriService favoriService;
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateFavoriRequest createFavoriRequest) {
		this.favoriService.add(createFavoriRequest);
	}
	
	@GetMapping()
	@ResponseStatus(code = HttpStatus.OK)
	public List<GetAllFavoriResponse> getAllFavori(){
		return this.favoriService.getAll();
	}
	
	@GetMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public GetFavoriByIdResponse getById(@PathVariable int id){
		return this.favoriService.getById(id);
	}
	
	@GetMapping("/alicilar/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<GetFavoriByAliciIdResponse> getByAliciId(@PathVariable int id) {
		return this.favoriService.getByAliciId(id);
	}
	
	@GetMapping("/otoparklar/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<GetFavoriByOtoparkIdResponse> getByOtoparId(@PathVariable int id) {
		return this.favoriService.getByOtoparkId(id);
	}
	
	@DeleteMapping()
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void delete(int id) {
		this.favoriService.delete(id);
	}
	
	
}
