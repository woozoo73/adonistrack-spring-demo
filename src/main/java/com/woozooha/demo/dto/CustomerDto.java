package com.woozooha.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CustomerDto {

    private Long id;

    @Schema(example = "Hazin")
    private String firstName;

    @Schema(example = "Woo")
    private String lastName;

}
