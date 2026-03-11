package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GreetingController {

    @GetMapping("/greeting")
    public Map<String, String> greeting() {

        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello World");

        return response;
    }
}