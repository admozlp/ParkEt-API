package com.ademozalp.ParkEt.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateParkingLotRequest {
	
	@NotNull
	private Long id;
	
	@NotNull
	@NotBlank
	private String name;
	
	@NotNull
	@NotBlank
	private String latitude;

	@NotNull
	@NotBlank
	private String longitude;

	@NotNull
	private Double parkingFee;
	
	@NotNull
	private Long capacity;
}
