package com.example.springframework.controller;

import com.example.springframework.service.HomeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/test")
    public String test() {
        return homeService.getMessage();
    }
}