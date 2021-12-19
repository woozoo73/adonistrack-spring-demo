package com.woozooha.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.woozooha.demo.dto.CustomerDto;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private Long greetingCount;

    @Builder
    public Customer(String firstName, String lastName, Long greetingCount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.greetingCount = greetingCount;
    }

    public void updateCustomer(String firstName, String lastName) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    }

    public void updateCustomer(Long greetingCount) {
    	this.greetingCount = greetingCount;
    }

    public CustomerDto customerToCustomerDto() {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(this.id);
        customerDto.setFirstName(this.firstName);
        customerDto.setLastName(this.lastName);
        return customerDto;
    }

}
