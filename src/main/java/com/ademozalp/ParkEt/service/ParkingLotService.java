package com.ademozalp.ParkEt.service;

import com.ademozalp.ParkEt.dto.request.CreateParkingLotRequest;
import com.ademozalp.ParkEt.dto.request.UpdateParkingLotRequest;
import com.ademozalp.ParkEt.dto.response.ParkingLotDTO;

import java.util.List;

public interface ParkingLotService {
    ParkingLotDTO create(CreateParkingLotRequest createParkingLotRequest);

    List<ParkingLotDTO> getAllParkingLot();

    ParkingLotDTO getParkingLotById(Long id);

    List<ParkingLotDTO> getAllParkingLotBySellerId(Long id);

    List<ParkingLotDTO> getAllParkingLotByPostalCodeId(Long id);

    List<ParkingLotDTO> getByCapacity(Long capacity);

    List<ParkingLotDTO> getByParkingLotFee(Double parkingLotFee);

    void delete(Long id);

    void deleteBySellerId(Long id);

    ParkingLotDTO update(UpdateParkingLotRequest updateParkingLotRequest);

}
