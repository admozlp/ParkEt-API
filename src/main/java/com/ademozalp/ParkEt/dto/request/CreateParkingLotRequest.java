package com.ademozalp.ParkEt.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateParkingLotRequest {
    @NotNull
    @NotBlank
    @Size(min = 3)
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 2)
    private String latitude;

    @NotNull
    @NotBlank
    @Size(min = 2)
    private String longitude;

    @NotNull
    private Double parkingFee;

    @NotNull
    private Long capacity;

    @NotNull
    private Long sellerId;

    @NotNull
    private Long postalCodeId;
}
