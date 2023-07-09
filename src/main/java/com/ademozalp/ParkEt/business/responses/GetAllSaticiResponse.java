package com.ademozalp.ParkEt.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllSaticiResponse {
	private int id;
	private String name;
	private String mail;	
	private String telefon;
}
