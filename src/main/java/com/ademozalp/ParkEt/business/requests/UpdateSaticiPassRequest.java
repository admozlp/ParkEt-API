package com.ademozalp.ParkEt.business.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSaticiPassRequest {
	
	@NotNull
	private int id;
	
	@NotNull
	@NotEmpty
	private String eskiPass;
	
	@NotNull
	@NotEmpty
	private String yeniPass;
	
	@NotNull
	@NotEmpty
	private String yeniPassTekrar;
	
}
