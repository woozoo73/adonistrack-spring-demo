package com.woozooha.demo.service;

import com.woozooha.demo.entity.Customer;
import com.woozooha.demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomer(Long id) {
        log.info("id={}", id);
        log.info("customerRepository={}", customerRepository);

        return customerRepository.findById(id).orElse(null);
    }

}
