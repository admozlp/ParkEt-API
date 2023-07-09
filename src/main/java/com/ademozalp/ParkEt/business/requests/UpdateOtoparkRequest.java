package com.ademozalp.ParkEt.business.requests;

import com.ademozalp.ParkEt.entities.concretes.PostaKodu;
import com.ademozalp.ParkEt.entities.concretes.Satici;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOtoparkRequest {
	
	@NotNull
	private int id;
	
	@NotNull
	@NotBlank
	private String adi;
	
	@NotNull
	@NotBlank
	private String latitude;

	@NotNull
	@NotBlank
	private String longitude;

	@NotNull
	private double ucret;
	
	@NotNull
	private int kapasite;
	
	@NotNull
	private Satici satici;	
	
	@NotNull
	private PostaKodu postaKodu;
}
