package com.ademozalp.ParkEt.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingLotDTO {
    private Long id;
    private String name;
    private String latitude;
    private String longitude;
    private Double parkingFee;
    private Long capacity;
    private SellerDTO sellerDTO;
    private PostalCodeDTO postalCodeDTO;
}
