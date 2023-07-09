package com.ademozalp.ParkEt.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSaticiRequest {
	
	
	@NotNull
	private int id;
	
	@NotNull
	@NotBlank
	private String name;

	@NotNull
	@NotBlank
	private String mail;
	
	@NotNull
	@NotBlank
	private String telefon;
	
	@NotNull
	@NotBlank
	private String pass;
}
