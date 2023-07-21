package com.ademozalp.ParkEt.repository;

import com.ademozalp.ParkEt.model.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {
    boolean existsByName(String name);

    List<ParkingLot> findAllBySellerId(Long id);

    boolean existsBySellerId(Long id);

    List<ParkingLot> findAllByPostalCodeId(Long id);

    boolean existsByPostalCodeId(Long id);

    List<ParkingLot> findAllByCapacityGreaterThanEqual(Long capacity);

    List<ParkingLot> findAllByParkingFeeLessThanEqual(Double parkingFee);

    @Transactional
    void deleteBySellerId(@Param("sellerId") Long sellerId);

}
