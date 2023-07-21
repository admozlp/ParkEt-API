package com.ademozalp.ParkEt.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFavoriteRequest {
	
	@NotNull
	private Long parkingLotId;
	
	@NotNull
	private Long customerId;
}
