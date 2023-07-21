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
public class UpdateCustomerPasswordRequest {

    @NotNull
    private Long id;

    @NotNull
    @NotBlank
    @Size(min = 4, max = 20)
    private String newPassword;

    @NotNull
    @NotBlank
    @Size(min = 4, max = 20)
    private String confirmNewPassword;
}
