package com.ademozalp.ParkEt.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ademozalp.ParkEt.business.abstracts.OtoparkService;
import com.ademozalp.ParkEt.business.requests.CreateOtoparkRequest;
import com.ademozalp.ParkEt.business.requests.UpdateOtoparkRequest;
import com.ademozalp.ParkEt.business.responses.GetAllOtoparkByPostaKodId;
import com.ademozalp.ParkEt.business.responses.GetAllOtoparkBySaticiId;
import com.ademozalp.ParkEt.business.responses.GetAllOtoparkKapasiteGreaterThanEqual;
import com.ademozalp.ParkEt.business.responses.GetAllOtoparkResponse;
import com.ademozalp.ParkEt.business.responses.GetByUcretLessThanEqual;
import com.ademozalp.ParkEt.business.responses.GetOtoparkById;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/otoparklar")
@AllArgsConstructor
public class OtoparkController {
	@Autowired
	private OtoparkService otoparkService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateOtoparkRequest createOtoparkRequest) {
		otoparkService.add(createOtoparkRequest);
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<GetAllOtoparkResponse> getAll(){
		return this.otoparkService.getAllOtopark();
	}
	
	@GetMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public GetOtoparkById getOtoparkById(@PathVariable int id) {
		return this.otoparkService.getOtoparkById(id);
	}
	
	@GetMapping("/saticilar/{saticiId}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<GetAllOtoparkBySaticiId> getAllOtoparkBySaticiId(@PathVariable("saticiId") int saticiId){
		return this.otoparkService.getAllOtoparkBySaticiId(saticiId);
	}
	
	@GetMapping("/postakodu/{postaKoduId}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<GetAllOtoparkByPostaKodId> getAllOtoparkByPostaKodId(@PathVariable("postaKoduId") int id){
		return this.otoparkService.getAllOtoparkByPostaKodId(id);
	}
	
	@GetMapping("/kapasite")
	@ResponseStatus(code = HttpStatus.OK)
	public List<GetAllOtoparkKapasiteGreaterThanEqual> allOtoparkKapasiteGreaterThanEquals(@RequestParam int min){
		return this.otoparkService.getByKapasite(min);
	}
	
	@GetMapping("/ucret")
	@ResponseStatus(code = HttpStatus.OK)
	public List<GetByUcretLessThanEqual> getByUcret(@RequestParam double maxucret){
		return this.otoparkService.getByUcret(maxucret);
	}
	
	@DeleteMapping()
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void delete(@RequestParam int id) {
		this.otoparkService.delete(id);
	}
	
	@DeleteMapping("/deletebysatici")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void deleteAllBySaticiId(@RequestParam("saticiId") int saticiId) {
		this.otoparkService.deleteBySaticiId(saticiId);
	}
	
	@PutMapping()
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void update(@RequestBody @Valid UpdateOtoparkRequest updateOtoparkRequest) {
		this.otoparkService.update(updateOtoparkRequest);
	}

}
