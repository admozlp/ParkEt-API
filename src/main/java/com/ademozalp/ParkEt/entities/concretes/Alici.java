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

@Table(name="alicilar")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Alici {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;

	@Column(name="email", unique = true)
	private String email;
	
	@Column(name="pass")
	private String pass;
	
	@OneToMany(mappedBy = "alici")
	private List<Favori> favoriler;
}
