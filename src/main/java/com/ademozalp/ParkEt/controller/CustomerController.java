package com.ademozalp.ParkEt.controller;

import com.ademozalp.ParkEt.dto.request.CreateCustomerRequest;
import com.ademozalp.ParkEt.dto.request.UpdateCustomerPasswordRequest;
import com.ademozalp.ParkEt.dto.request.UpdateCustomerRequest;
import com.ademozalp.ParkEt.dto.response.CustomerDTO;
import com.ademozalp.ParkEt.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<CustomerDTO> create(@RequestBody @Valid CreateCustomerRequest createCustomerRequest) {

        CustomerDTO customerDTO = this.customerService.create(createCustomerRequest);

        return new ResponseEntity<>(customerDTO, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<CustomerDTO>> getAll() {
        List<CustomerDTO> customerDTOS = this.customerService.getAllCustomers();

        return new ResponseEntity<>(customerDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        CustomerDTO customerDTO = this.customerService.getCustomerById(id);

        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @GetMapping("/byemail")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<CustomerDTO> getCustomerByEmail(@RequestParam("email") String email) {
        CustomerDTO customerDTO = this.customerService.getCustomerByEmail(email);

        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        this.customerService.delete(id);

        return new ResponseEntity<>("Başarıyla silindi.", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<CustomerDTO> update(@RequestBody @Valid UpdateCustomerRequest updateCustomerRequest) {
        CustomerDTO customerDTO = this.customerService.update(updateCustomerRequest);

        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @PutMapping("/updatepassword")
    public ResponseEntity<CustomerDTO> updatePassword(@RequestBody @Valid UpdateCustomerPasswordRequest
                                                              updateCustomerPasswordRequest) {
        CustomerDTO customerDTO = this.customerService.updatePassword(updateCustomerPasswordRequest);

        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

}
