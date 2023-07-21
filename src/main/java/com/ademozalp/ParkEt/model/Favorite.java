package com.ademozalp.ParkEt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Table(name = "favorites")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parkinglot_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ParkingLot parkingLot;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customer customer;

    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

}
