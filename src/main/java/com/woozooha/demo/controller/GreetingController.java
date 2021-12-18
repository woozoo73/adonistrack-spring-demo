package com.woozooha.demo.controller;

import com.woozooha.demo.dto.GreetingDto;
import com.woozooha.demo.service.GreetingService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class GreetingController {

    private final GreetingService greetingService;

    @GetMapping("/greeting/{id}")
    public GreetingDto greeting(@Parameter(example = "1") @PathVariable Long id, @RequestParam(value = "name", defaultValue = "World") String name) {
        return greetingService.getGreeting(id, name);
    }

}
