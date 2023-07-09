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

import com.ademozalp.ParkEt.business.abstracts.AliciService;
import com.ademozalp.ParkEt.business.requests.CreateAliciRequest;
import com.ademozalp.ParkEt.business.requests.UpdateAliciPassRequest;
import com.ademozalp.ParkEt.business.requests.UpdateAliciRequest;
import com.ademozalp.ParkEt.business.responses.GetAliciByEmailResponse;
import com.ademozalp.ParkEt.business.responses.GetAliciByIdResponse;
import com.ademozalp.ParkEt.business.responses.GetAllAliciResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/alicilar")
@AllArgsConstructor
public class AliciController {
	@Autowired
	private AliciService aliciService;
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateAliciRequest createAliciRequest) {
		this.aliciService.add(createAliciRequest);
	}
	
	@GetMapping()
	@ResponseStatus(code = HttpStatus.OK)
	public List<GetAllAliciResponse> getAll() {
		return this.aliciService.getAllAlici();
	}
	
	@GetMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public GetAliciByIdResponse getAliciById(@PathVariable int id) {
		return this.aliciService.getAliciById(id);
	}
	
	@GetMapping("/bymail")
	@ResponseStatus(code = HttpStatus.OK)
	public GetAliciByEmailResponse getAliciByEmail(@RequestParam("email") String email) {
		return this.aliciService.getAliciByEmail(email);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void delete(@PathVariable int id) {
		this.aliciService.delete(id);
	}
	
	@PutMapping()
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void update(@RequestBody @Valid UpdateAliciRequest updateAliciRequest) {
		this.aliciService.update(updateAliciRequest);
	}
	
	@PutMapping("/updatepass")
	public void updatePass(@RequestBody @Valid UpdateAliciPassRequest aliciPassRequest) {
		this.aliciService.updatePass(aliciPassRequest);
	}

}
