package com.woozooha.demo.service;

import com.woozooha.demo.dto.CustomerDto;
import com.woozooha.demo.entity.Customer;
import com.woozooha.demo.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDto create(CustomerDto dto) {
        Customer customer = new Customer();
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());

        Customer saved = customerRepository.save(customer);

        CustomerDto savedDto = new CustomerDto();
        savedDto.setId(saved.getId());
        savedDto.setFirstName(saved.getFirstName());
        savedDto.setLastName(saved.getLastName());

        return savedDto;
    }

    public void update(CustomerDto dto) {
        Customer customer = customerRepository.getById(dto.getId());
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    public CustomerDto get(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            return null;
        }

        CustomerDto dto = new CustomerDto();
        dto.setId(customer.getId());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());

        return dto;
    }

    public void raiseGreetingCount(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            return;
        }

        customer.setGreetingCount(customer.getGreetingCount() + 1);
    }

}
