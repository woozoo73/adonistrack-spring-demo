package com.woozooha.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class CustomerDto {

    private Long id;

    @Schema(example = "Hazin")
    private String firstName;

    @Schema(example = "Woo")
    private String lastName;

    public CustomerDto() {
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return "CustomerDto(id=" + this.getId() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ")";
    }

}
