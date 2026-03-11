package greetingapp.service;

import greetingapp.model.Greeting;
import greetingapp.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public Greeting saveGreeting(String message) {
        Greeting g = new Greeting();
        g.setMessage(message);
        return greetingRepository.save(g);
    }

    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id).orElse(null);
    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public Greeting updateGreeting(Long id, String message) {
        Greeting g = greetingRepository.findById(id).orElse(null);
        if (g != null) {
            g.setMessage(message);
            return greetingRepository.save(g);
        }
        return null;
    }

    public String deleteGreeting(Long id) {
        greetingRepository.deleteById(id);
        return "Deleted";
    }
}