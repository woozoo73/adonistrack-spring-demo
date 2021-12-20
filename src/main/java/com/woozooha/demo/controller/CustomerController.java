package com.woozooha.demo.controller;

import com.woozooha.demo.dto.CustomerDto;
import com.woozooha.demo.service.CustomerService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer/{id}")
    public CustomerDto get(@Parameter(example = "1") @PathVariable Long id) {
        return customerService.get(id);
    }

    @PostMapping("/customer")
    public CustomerDto create(@RequestBody CustomerDto dto) {
        return customerService.create(dto);
    }

    @PutMapping("/customer/{id}")
    public CustomerDto update(@Parameter(example = "1") @PathVariable Long id, @RequestBody CustomerDto dto) {
        dto.setId(id);

        return customerService.create(dto);
    }

    @DeleteMapping("/customer/{id}")
    public void delete(@Parameter(example = "1") @PathVariable Long id) {
        customerService.delete(id);
    }

}
