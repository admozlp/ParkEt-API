package com.ademozalp.ParkEt.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOtoparkRequest {
	@NotNull
	@NotBlank
	@Size(min = 3)
	private String adi;
	
	@NotNull
	@NotBlank
	@Size(min = 2)
	private String latitude;

	@NotNull
	@NotBlank
	@Size(min = 2)
	private String longitude;

	@NotNull
	private double ucret;
	
	@NotNull
	private int kapasite;
	
	@NotNull
	private int saticiId;	
	
	@NotNull
	private int postaKoduId;



}
