package com.woozooha.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private Long greetingCount;

    public Customer(Long id, String firstName, String lastName, Long greetingCount) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.greetingCount = greetingCount;
    }

    public Customer() {
    }

    public Long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Long getGreetingCount() {
        return this.greetingCount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGreetingCount(Long greetingCount) {
        this.greetingCount = greetingCount;
    }

}
