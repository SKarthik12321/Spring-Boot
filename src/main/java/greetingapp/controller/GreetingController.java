package greetingapp.controller;

import greetingapp.model.Greeting;
import greetingapp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @PostMapping("/greeting")
    public Greeting saveGreeting(@RequestParam String message) {
        return greetingService.saveGreeting(message);
    }
}