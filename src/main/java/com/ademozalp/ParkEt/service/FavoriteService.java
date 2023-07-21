package com.ademozalp.ParkEt.service;

import com.ademozalp.ParkEt.dto.request.CreateFavoriteRequest;
import com.ademozalp.ParkEt.dto.response.FavoriteDTO;

import java.util.List;

public interface FavoriteService {
    FavoriteDTO create(CreateFavoriteRequest createFavoriteRequest);

    List<FavoriteDTO> getAll();

    FavoriteDTO getById(Long id);

    List<FavoriteDTO> getByCustomerId(Long id);

    List<FavoriteDTO> getByParkingLotId(Long id);

    void delete(Long id);
}
