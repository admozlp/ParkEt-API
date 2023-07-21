package com.ademozalp.ParkEt.controller;

import com.ademozalp.ParkEt.dto.request.CreateParkingLotRequest;
import com.ademozalp.ParkEt.dto.request.UpdateParkingLotRequest;
import com.ademozalp.ParkEt.dto.response.ParkingLotDTO;
import com.ademozalp.ParkEt.service.ParkingLotService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parkinglots")
@AllArgsConstructor
public class ParkingLotController {

    private final ParkingLotService parkingLotService;

    @PostMapping("/create")
    public ResponseEntity<ParkingLotDTO> create(@RequestBody @Valid CreateParkingLotRequest createParkingLotRequest) {
        ParkingLotDTO parkingLotDTO = parkingLotService.create(createParkingLotRequest);

        return new ResponseEntity<>(parkingLotDTO, HttpStatus.CREATED);
    }

    @GetMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<ParkingLotDTO>> getAll() {
        List<ParkingLotDTO> parkingLotDTOS = this.parkingLotService.getAllParkingLot();

        return new ResponseEntity<>(parkingLotDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingLotDTO> getOtoparkById(@PathVariable Long id) {
        ParkingLotDTO parkingLotDTO = this.parkingLotService.getParkingLotById(id);

        return new ResponseEntity<>(parkingLotDTO, HttpStatus.OK);
    }

    @GetMapping("/seller/{id}")
    public ResponseEntity<List<ParkingLotDTO>> getAllParkingLotBySellerId(@PathVariable("id") Long id) {

        List<ParkingLotDTO> parkingLotDTOS = this.parkingLotService.getAllParkingLotBySellerId(id);

        return new ResponseEntity<>(parkingLotDTOS, HttpStatus.OK);
    }

    @GetMapping("/postalcode/{id}")
    public ResponseEntity<List<ParkingLotDTO>> getAllParkingLotByPostalCodeId(@PathVariable("id") Long id) {

        List<ParkingLotDTO> parkingLotDTOS = this.parkingLotService.getAllParkingLotByPostalCodeId(id);

        return new ResponseEntity<>(parkingLotDTOS, HttpStatus.OK);
    }

    @GetMapping("/capacity")
    public ResponseEntity<List<ParkingLotDTO>> getByCapacity(@RequestParam Long capacity) {
        List<ParkingLotDTO> parkingLotDTOS = this.parkingLotService.getByCapacity(capacity);

        return new ResponseEntity<>(parkingLotDTOS, HttpStatus.OK);
    }

    @GetMapping("/parkinglotfee")
    public ResponseEntity<List<ParkingLotDTO>> getByParkingLotFee(@RequestParam Double parkingLotFee) {
        List<ParkingLotDTO> parkingLotDTOS = this.parkingLotService.getByParkingLotFee(parkingLotFee);

        return new ResponseEntity<>(parkingLotDTOS, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        this.parkingLotService.delete(id);

        return new ResponseEntity<>("Başarıyla silindi.", HttpStatus.OK);
    }

    @DeleteMapping("/delete/seller/{id}")
    public ResponseEntity<String> deleteAllBySellerId(@PathVariable("id") Long id) {
        this.parkingLotService.deleteBySellerId(id);

        return new ResponseEntity<>("Başarıyla Silindi.", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ParkingLotDTO> update(@RequestBody @Valid UpdateParkingLotRequest updateParkingLotRequest) {
        ParkingLotDTO parkingLotDTO = this.parkingLotService.update(updateParkingLotRequest);

        return new ResponseEntity<>(parkingLotDTO, HttpStatus.OK);
    }

}
