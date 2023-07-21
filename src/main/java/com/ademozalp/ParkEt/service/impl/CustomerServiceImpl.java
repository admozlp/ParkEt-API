package com.ademozalp.ParkEt.service.impl;

import com.ademozalp.ParkEt.config.mapper.ModelMapperService;
import com.ademozalp.ParkEt.dto.request.CreateCustomerRequest;
import com.ademozalp.ParkEt.dto.request.UpdateCustomerPasswordRequest;
import com.ademozalp.ParkEt.dto.request.UpdateCustomerRequest;
import com.ademozalp.ParkEt.dto.response.CustomerDTO;
import com.ademozalp.ParkEt.model.Customer;
import com.ademozalp.ParkEt.repository.CustomerRepository;
import com.ademozalp.ParkEt.service.CustomerService;
import com.ademozalp.ParkEt.service.rules.CustomerBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerBusinessRules customerBusinessRules;
    private final ModelMapperService modelMapperService;

    @Override
    public CustomerDTO create(CreateCustomerRequest createCustomerRequest) {
        this.customerBusinessRules.existsByEmail(createCustomerRequest.getEmail());

        Customer customer = this.modelMapperService.forRequest()
                .map(createCustomerRequest, Customer.class);

        this.customerRepository.save(customer);

        CustomerDTO customerDTO =
                new CustomerDTO(customer.getId(), customer.getFirstName(), customer.getLastName(),
                        customer.getEmail());

        return customerDTO;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = this.customerRepository.findAll();

        return customers.stream().map(customer ->
                this.modelMapperService.forResponse()
                        .map(customer, CustomerDTO.class)).toList();

    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        this.customerBusinessRules.existsById(id);

        Customer customer = this.customerRepository.findById(id).orElseThrow();

        return this.modelMapperService.forResponse()
                .map(customer, CustomerDTO.class);
    }

    @Override
    public CustomerDTO getCustomerByEmail(String email) {
        this.customerBusinessRules.checkMailExists(email);

        Customer customer = this.customerRepository.findByEmail(email);

        return this.modelMapperService.forResponse()
                .map(customer, CustomerDTO.class);
    }

    @Override
    public void delete(Long id) {
        this.customerBusinessRules.existsById(id);

        this.customerRepository.deleteById(id);
    }

    @Override
    public CustomerDTO update(UpdateCustomerRequest updateCustomerRequest) {
        this.customerBusinessRules.existsById(updateCustomerRequest.getId());

        Customer oldCustomer = this.customerRepository.findById(updateCustomerRequest.getId()).orElseThrow();
        oldCustomer.setFirstName(updateCustomerRequest.getFirstName());
        oldCustomer.setLastName(updateCustomerRequest.getLastName());
        oldCustomer.setEmail(updateCustomerRequest.getEmail());

        Customer updatedCustomer = this.customerRepository.save(oldCustomer);

        return this.getCustomerById(updatedCustomer.getId());
    }

    @Override
    public CustomerDTO updatePassword(UpdateCustomerPasswordRequest updateCustomerPasswordRequest) {
        this.customerBusinessRules.existsById(updateCustomerPasswordRequest.getId());

        Customer customer = this.customerRepository
                .findById(updateCustomerPasswordRequest.getId()).orElseThrow();

        customer.setPassword(updateCustomerPasswordRequest.getNewPassword());

        this.customerRepository.save(customer);

        return this.getCustomerById(customer.getId());
    }

}
