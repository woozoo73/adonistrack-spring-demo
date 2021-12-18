package com.woozooha.demo.service;

import com.woozooha.demo.dto.GreetingDto;
import com.woozooha.demo.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GreetingService {

    private final CustomerService customerService;

    public GreetingDto getGreeting(Long id, String name) {
        Customer customer = customerService.getCustomer(id);
        String customerName = name;
        if (customer != null) {
            customerName = customer.getFirstName() + " " + customer.getLastName();
        }

        GreetingDto greetingDto = new GreetingDto();
        greetingDto.setId(id);
        greetingDto.setContent("Hello, " + customerName);

        return greetingDto;
    }

}
