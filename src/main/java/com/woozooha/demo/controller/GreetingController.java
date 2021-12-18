package com.woozooha.demo.controller;

import com.woozooha.demo.dto.GreetingDto;
import com.woozooha.demo.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GreetingController {

    private final GreetingService greetingService;

    @GetMapping("/greeting/{id}")
    public GreetingDto greeting(@PathVariable Long id, @RequestParam(value = "name", defaultValue = "World") String name) {
        return greetingService.getGreeting(id, name);
    }

}
