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
public class UpdateAliciPassRequest {
	
	@NotNull
	private int id;
	
	@NotNull
	@NotBlank
	@Size(min = 4, max =20)
	private String pass;
	
	@NotNull
	@NotBlank
	@Size(min = 4, max =20)
	private String yeniPass;
	
	@NotNull
	@NotBlank
	@Size(min = 4, max =20)
	private String yeniPassTekrar;
}
