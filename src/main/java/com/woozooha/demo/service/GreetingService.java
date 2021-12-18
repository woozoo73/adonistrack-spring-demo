package com.woozooha.demo.service;

import com.woozooha.demo.dto.CustomerDto;
import com.woozooha.demo.dto.GreetingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GreetingService {

    private final CustomerService customerService;

    public GreetingDto getGreeting(Long id, String name) {
        CustomerDto customerDto = customerService.get(id);
        String customerName = name;
        if (customerDto != null) {
            customerService.raiseGreetingCount(id);
            customerName = customerDto.getFirstName() + " " + customerDto.getLastName();
        }

        GreetingDto greetingDto = new GreetingDto();
        greetingDto.setId(id);
        greetingDto.setContent("Hello, " + customerName);

        return greetingDto;
    }

}
