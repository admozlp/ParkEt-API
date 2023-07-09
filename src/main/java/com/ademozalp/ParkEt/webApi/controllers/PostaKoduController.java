package com.ademozalp.ParkEt.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ademozalp.ParkEt.business.abstracts.PostaKoduService;
import com.ademozalp.ParkEt.entities.concretes.PostaKodu;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/postakodlari")
@AllArgsConstructor
public class PostaKoduController {
	@Autowired
	private PostaKoduService koduService;
	
	@PostMapping()
	public void add(@RequestBody PostaKodu kodu) {
		koduService.add(kodu);
	}
}
