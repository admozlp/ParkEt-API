package com.ademozalp.ParkEt.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetFavoriByAliciIdResponse {
	private int id;
	
	private String tarihSaat;
	
	private int aliciId;
	private String aliciEmail;
	private String aliciName;
	private String aliciSurname;
	
	private int otoparkId;
	private String otoparkAdi;
	private int otoparkKapasite;
	private String otoparkLatitude;
	private String otoparkLongitude;
	private double otoparkUcret;
	
	private int otoparkPostaKoduId;
	private String postakodlariKod;
	
	private int otoparkSaticiId;
	private String saticiMail;
	private String saticiName;
	private String saticiTelefon;
}
