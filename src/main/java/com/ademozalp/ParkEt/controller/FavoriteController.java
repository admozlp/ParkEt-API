package com.ademozalp.ParkEt.controller;

import com.ademozalp.ParkEt.dto.request.CreateFavoriteRequest;
import com.ademozalp.ParkEt.dto.response.FavoriteDTO;
import com.ademozalp.ParkEt.service.FavoriteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
@AllArgsConstructor
public class FavoriteController {

    private final FavoriteService favoriteService;

    @PostMapping("/create")
    public ResponseEntity<FavoriteDTO> create(@RequestBody @Valid CreateFavoriteRequest createFavoriteRequest) {
        FavoriteDTO favoriteDTO = this.favoriteService.create(createFavoriteRequest);

        return new ResponseEntity<>(favoriteDTO, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<FavoriteDTO>> getAll() {
        List<FavoriteDTO> favoriteDTOS = this.favoriteService.getAll();

        return new ResponseEntity<>(favoriteDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FavoriteDTO> getById(@PathVariable Long id) {
        FavoriteDTO favoriteDTO = this.favoriteService.getById(id);

        return new ResponseEntity<>(favoriteDTO, HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<FavoriteDTO>> getByCustomerId(@PathVariable Long id) {
        List<FavoriteDTO> favoriteDTOS = this.favoriteService.getByCustomerId(id);

        return new ResponseEntity<>(favoriteDTOS, HttpStatus.OK);
    }

    @GetMapping("/parkinglot/{id}")
    public ResponseEntity<List<FavoriteDTO>> getByParkingLotId(@PathVariable Long id) {
        List<FavoriteDTO> favoriteDTOS = this.favoriteService.getByParkingLotId(id);

        return new ResponseEntity<>(favoriteDTOS, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<String> delete(Long id) {
        this.favoriteService.delete(id);

        return new ResponseEntity<>("Başarıyla silindi.", HttpStatus.OK);
    }


}
