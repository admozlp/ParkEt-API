package com.ademozalp.ParkEt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "sellers")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "telephone", unique = true)
    private String telephone;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private List<ParkingLot> parkingLots;
}
