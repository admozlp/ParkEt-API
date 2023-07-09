package com.ademozalp.ParkEt.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByUcretLessThanEqual {
	private int id;
	private String adi;
	private String latitude;
	private String longitude;
	private double ucret;
	private int kapasite;
	
	private int saticiId;
	private String saticiMail;
	private String saticiName;
	private String saticiTelefon;
	
	private int postaKoduId;
	private String postakodlariKod;	
}
