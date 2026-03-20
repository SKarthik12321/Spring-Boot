package com.example.springframework.service;

import org.springframework.stereotype.Service;

@Service
public class HomeService {

    public String getMessage() {
        return "Service Layer Working";
    }
}
