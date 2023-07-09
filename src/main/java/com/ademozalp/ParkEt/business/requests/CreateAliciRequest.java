package com.ademozalp.ParkEt.business.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAliciRequest {
	
	@NotNull
	@NotBlank
	@Size(min = 3, max=15)
	private String name;
	
	@NotNull
	@NotBlank
	@Size(min = 2, max=15)
	private String surname;

	@NotNull
	@NotBlank
	@Size(min = 11,max=50)
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
    flags = Pattern.Flag.CASE_INSENSITIVE)
	private String email;
	
	@NotNull
	@NotBlank
	@Size(min = 4, max =20)
	private String pass;
	
}
