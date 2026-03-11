package springintro;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    // UC1
    @GetMapping("/hello")
    public String hello() {
        return "Hello from BridgeLabz";
    }
}