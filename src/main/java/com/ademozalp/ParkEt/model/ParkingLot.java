package com.ademozalp.ParkEt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Table(name = "parkinglots")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "parking_fee")
    private Double parkingFee;

    @Column(name = "capacity")
    private Long capacity;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Seller seller;

    @ManyToOne
    @JoinColumn(name = "postalcode_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private PostalCode postalCode;

    @OneToMany(mappedBy = "parkingLot", cascade = CascadeType.ALL)
    private List<Favorite> favorites;
}
