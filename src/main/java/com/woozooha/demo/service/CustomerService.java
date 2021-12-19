package com.woozooha.demo.service;

import com.woozooha.demo.dto.CustomerDto;
import com.woozooha.demo.entity.Customer;
import com.woozooha.demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerDto create(CustomerDto dto) {
        Customer customer = dto.customerDtoToCustomer();

        Customer saved = customerRepository.save(customer);

        CustomerDto savedDto = saved.customerToCustomerDto();

        return savedDto;
    }

    public void update(CustomerDto dto) {
        Customer customer = customerRepository.getById(dto.getId());
        customer.updateCustomer(dto.getFirstName(), dto.getLastName());
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public CustomerDto get(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            return null;
        }

        CustomerDto dto = customer.customerToCustomerDto();

        return dto;
    }

    public void raiseGreetingCount(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            return;
        }

        customer.updateCustomer(customer.getGreetingCount() + 1);
    }

}
