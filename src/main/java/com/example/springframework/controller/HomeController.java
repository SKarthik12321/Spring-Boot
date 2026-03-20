package com.example.springframework.controller;

import com.example.springframework.dto.EmployeeDTO;
import com.example.springframework.model.Employee;
import com.example.springframework.service.HomeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class HomeController {

    private final HomeService service;

    public HomeController(HomeService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String test() {
        return service.getMessage();
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public Employee getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public Employee create(@RequestBody EmployeeDTO dto) {
        return service.saveFromDTO(dto);
    }

    @PutMapping("/update/{id}")
    public Employee update(@PathVariable Long id, @RequestBody EmployeeDTO dto) {
        return service.updateFromDTO(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted";
    }
}