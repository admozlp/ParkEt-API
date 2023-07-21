package com.ademozalp.ParkEt.controller;

import com.ademozalp.ParkEt.dto.request.CreatePostalCodeRequest;
import com.ademozalp.ParkEt.dto.response.PostalCodeDTO;
import com.ademozalp.ParkEt.service.PostalCodeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/postalcodes")
@AllArgsConstructor
public class PostalCodeController {

    private final PostalCodeService postalCodeService;

    @PostMapping("/create")
    public ResponseEntity<PostalCodeDTO> create(@RequestBody CreatePostalCodeRequest createPostalCodeRequest) {
        PostalCodeDTO postalCodeDTO = this.postalCodeService.create(createPostalCodeRequest);

        return new ResponseEntity<>(postalCodeDTO, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<PostalCodeDTO>> getAllPostalCodes() {
        List<PostalCodeDTO> postalCodeDTOS = this.postalCodeService.getAllPostalCodes();

        return new ResponseEntity<>(postalCodeDTOS, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<PostalCodeDTO> getById(@PathVariable Long id) {
        PostalCodeDTO postalCodeDTO = this.postalCodeService.getPostalCodeById(id);

        return new ResponseEntity<>(postalCodeDTO, HttpStatus.OK);
    }
}
