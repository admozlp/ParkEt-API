package com.ademozalp.ParkEt.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSellerRequest {
	
	@NotNull
	@NotEmpty
	@Size(min=3, max = 20)
	private String name;

	@NotNull
	@NotEmpty
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE)
	@Size(min=11, max = 50)
	private String email;
	
	@NotNull
	@NotEmpty
	@Size(min=10, max = 11)
	private String telephone;
	
	@NotNull
	@NotEmpty
	@Size(min=4, max = 15)
	private String password;
}
