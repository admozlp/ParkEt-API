package com.ademozalp.ParkEt.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostalCodeRequest {

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 10)
    private Integer code;

}
