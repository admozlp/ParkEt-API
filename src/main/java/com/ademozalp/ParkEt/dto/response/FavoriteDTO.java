package com.ademozalp.ParkEt.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FavoriteDTO {
    private Long id;

    private LocalDateTime createdDate;

    private CustomerDTO customerDTO;

    private ParkingLotDTO parkingLotDTO;

    private SellerDTO sellerDTO;
}
