package com.ademozalp.ParkEt.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {

    @NotNull
    private Long id;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 15)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 15)
    private String lastName;

    @NotNull
    @NotBlank
    @Size(min = 11, max = 50)
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;
}
