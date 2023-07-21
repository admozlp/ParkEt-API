package com.ademozalp.ParkEt.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
	private Long id;
	
	private String firstName;
	
	private String lastName;

	private String email;
}
