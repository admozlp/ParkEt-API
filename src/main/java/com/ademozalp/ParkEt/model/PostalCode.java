package com.ademozalp.ParkEt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Table(name = "postalcodes")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PostalCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code", unique = true)
    private Integer code;

    @OneToMany(mappedBy = "postalCode")
    private List<ParkingLot> parkingLots;
}
