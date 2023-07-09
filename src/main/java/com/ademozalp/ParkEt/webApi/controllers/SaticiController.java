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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ademozalp.ParkEt.business.abstracts.SaticiService;
import com.ademozalp.ParkEt.business.requests.CreateSaticiRequest;
import com.ademozalp.ParkEt.business.requests.UpdateSaticiPassRequest;
import com.ademozalp.ParkEt.business.requests.UpdateSaticiRequest;
import com.ademozalp.ParkEt.business.responses.GetAllSaticiResponse;
import com.ademozalp.ParkEt.business.responses.GetSaticiById;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/saticilar")
@AllArgsConstructor
public class SaticiController {
	@Autowired
	private SaticiService saticiService;
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() @Valid() CreateSaticiRequest createSaticiRequest) {
		saticiService.add(createSaticiRequest);
	}
	
	@GetMapping()
	@ResponseStatus(code = HttpStatus.OK)
	public List<GetAllSaticiResponse> getall(){
		return saticiService.getAll();
	}
	
	@GetMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public GetSaticiById getSaticiById(@PathVariable int id) {
		return saticiService.getSaticiById(id);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void delete(@PathVariable int id) {
		saticiService.delete(id);
	}
	
	@PutMapping
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void update(@RequestBody @Valid UpdateSaticiRequest updateSaticiRequest) {
		saticiService.update(updateSaticiRequest);
	}
	
	@PutMapping("/updatepass")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void updatepass(@RequestBody UpdateSaticiPassRequest updateSaticiPassRequest) {
		this.saticiService.updatePass(updateSaticiPassRequest);
	}
	

}
