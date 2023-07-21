package com.ademozalp.ParkEt.repository;

import com.ademozalp.ParkEt.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    public boolean existsByCustomerId(Long id);

    public Favorite findByCustomerId(Long id);

    public List<Favorite> findAllByCustomerId(Long id);

    public List<Favorite> findAllByParkingLotId(Long id);
}
