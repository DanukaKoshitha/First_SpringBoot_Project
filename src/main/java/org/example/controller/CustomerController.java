package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Customer;
import org.example.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin
@RequiredArgsConstructor

public class CustomerController {

    final CustomerService service;

    @PostMapping("/add-customer")
    public void addCustomer(@RequestBody Customer customer){
        service.saveCustomer(customer);
    }

    @GetMapping("/get-customers")
    public List<Customer> showCustomers(){
        return service.getAll();
    }
}
