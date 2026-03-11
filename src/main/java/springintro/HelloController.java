package springintro;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    // UC1
    @GetMapping("/hello")
    public String hello() {
        return "Hello from BridgeLabz";
    }

    // UC2
    @GetMapping("/hello/query")
    public String helloQuery(@RequestParam String name) {
        return "Hello " + name + " from BridgeLabz";
    }
    // UC3
    @GetMapping("/hello/param/{name}")
    public String helloParam(@PathVariable String name) {
        return "Hello " + name + " from BridgeLabz";
    }

    // UC4
    @PostMapping("/hello/post")
    public String helloPost(@RequestBody String name) {
        return "Hello " + name + " from BridgeLabz";
    }

    // UC5
    @PutMapping("/hello/put/{name}")
    public String helloPut(@PathVariable String name, @RequestParam String lastName) {
        return "Hello " + name + " " + lastName + " from BridgeLabz";
    }
}