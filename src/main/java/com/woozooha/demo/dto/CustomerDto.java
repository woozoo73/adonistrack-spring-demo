package com.woozooha.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import com.woozooha.demo.entity.Customer;

@Data
public class CustomerDto {

    private Long id;

    @Schema(example = "Hazin")
    private String firstName;

    @Schema(example = "Woo")
    private String lastName;

    public Customer customerDtoToCustomer() {
//        Customer customer = new Customer(this.firstName, this.lastName);
        Customer customer = Customer.builder()
        .firstName(this.firstName)
        .lastName(this.lastName)
        .greetingCount(0L)
        .build();
        return customer;
    }

}
