package com.ademozalp.ParkEt.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="postkodlari")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostaKodu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="kod", unique = true)
	private String kod;
	
	@OneToMany(mappedBy = "postaKodu")
	private List<Otopark> otoparklar;
}
