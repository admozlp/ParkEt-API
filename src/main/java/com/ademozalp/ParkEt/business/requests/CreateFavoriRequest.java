package com.ademozalp.ParkEt.business.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFavoriRequest {
	
	@NotNull
	private int otoparkId;
	
	@NotNull
	private int aliciId;
}
