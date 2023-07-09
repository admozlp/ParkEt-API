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

@Table(name = "saticilar")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Satici {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;

	@Column(name="mail", unique = true)
	private String mail;
	
	@Column(name="telefon", unique = true)
	private String telefon;
	
	@Column(name="pass")
	private String pass;
	
	@OneToMany(mappedBy = "satici")
	private List<Otopark> otoparklar;
}
