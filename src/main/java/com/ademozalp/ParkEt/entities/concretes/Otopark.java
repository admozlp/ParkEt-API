package com.ademozalp.ParkEt.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="otoparklar")
public class Otopark {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="adi", unique = true)
	private String adi;
	
	@Column(name="latitude")
	private String latitude;

	@Column(name="longitude")
	private String longitude;

	@Column(name="ucret")
	private double ucret;
	
	@Column(name="kapasite")
	private int kapasite;
	
	@ManyToOne
	@JoinColumn(name="saticiId")
	private Satici satici;
	
	@ManyToOne
	@JoinColumn(name="postaKoduId")
	private PostaKodu postaKodu;	
	
	@OneToMany(mappedBy = "otopark")
	private List<Favori> favoriler;
}
