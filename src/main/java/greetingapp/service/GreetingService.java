package greetingapp.service;

import greetingapp.model.Greeting;
import greetingapp.repository.GreetingRepository;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public Greeting saveGreeting(String message) {
        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);
    }

    public String getGreeting(String firstName, String lastName) {

        if (firstName != null && lastName != null)
            return "Hello " + firstName + " " + lastName;

        if (firstName != null)
            return "Hello " + firstName;

        if (lastName != null)
            return "Hello " + lastName;

        return "Hello World";
    }
}