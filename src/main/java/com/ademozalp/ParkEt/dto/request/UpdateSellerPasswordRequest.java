package com.ademozalp.ParkEt.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSellerPasswordRequest {
	
	@NotNull
	private Long id;
	
	@NotNull
	@NotEmpty
	private String newPassword;
	
	@NotNull
	@NotEmpty
	private String confirmNewPassword;
	
}
