package com.ademozalp.ParkEt.service;

import com.ademozalp.ParkEt.dto.request.CreateCustomerRequest;
import com.ademozalp.ParkEt.dto.request.UpdateCustomerPasswordRequest;
import com.ademozalp.ParkEt.dto.request.UpdateCustomerRequest;
import com.ademozalp.ParkEt.dto.response.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO create(CreateCustomerRequest createCustomerRequest);

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(Long id);

    CustomerDTO getCustomerByEmail(String email);

    void delete(Long id);

    CustomerDTO update(UpdateCustomerRequest updateCustomerRequest);

    CustomerDTO updatePassword(UpdateCustomerPasswordRequest updateCustomerPasswordRequest);
}
