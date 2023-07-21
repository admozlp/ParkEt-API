package com.ademozalp.ParkEt.controller;

import com.ademozalp.ParkEt.dto.request.CreateSellerRequest;
import com.ademozalp.ParkEt.dto.request.UpdateSellerPasswordRequest;
import com.ademozalp.ParkEt.dto.request.UpdateSellerRequest;
import com.ademozalp.ParkEt.dto.response.SellerDTO;
import com.ademozalp.ParkEt.service.SellerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sellers")
@AllArgsConstructor
public class SellerController {

    private final SellerService sellerService;

    @PostMapping("/create")
    public ResponseEntity<SellerDTO> create(@RequestBody() @Valid() CreateSellerRequest createSellerRequest) {
        SellerDTO sellerDTO = this.sellerService.create(createSellerRequest);

        return new ResponseEntity<>(sellerDTO, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<SellerDTO>> getAll() {
        List<SellerDTO> sellerDTOS = this.sellerService.getAll();

        return new ResponseEntity<>(sellerDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SellerDTO> getSellerById(@PathVariable Long id) {
        SellerDTO sellerDTO = this.sellerService.getSellerById(id);

        return new ResponseEntity<>(sellerDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        sellerService.delete(id);

        return new ResponseEntity<>("Başarıyla silindi.", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<SellerDTO> update(@RequestBody @Valid UpdateSellerRequest updateSellerRequest) {
        SellerDTO sellerDTO = sellerService.update(updateSellerRequest);

        return new ResponseEntity<>(sellerDTO, HttpStatus.OK);
    }

    @PutMapping("/updatepassword")
    public ResponseEntity<SellerDTO> updatePassword(@RequestBody @Valid UpdateSellerPasswordRequest updateSellerPasswordRequest) {
        SellerDTO sellerDTO = this.sellerService.updatePassword(updateSellerPasswordRequest);

        return new ResponseEntity<>(sellerDTO, HttpStatus.OK);
    }


}
