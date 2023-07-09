package com.ademozalp.ParkEt.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "favoriler")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Favori {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "otoparkId")
	private Otopark otopark;
	
	@ManyToOne
	@JoinColumn(name = "aliciId")
	private Alici alici;
	
	@Column(name = "tarihSaat")
	@Temporal(TemporalType.TIMESTAMP)
	private java.sql.Timestamp date;
	
}
