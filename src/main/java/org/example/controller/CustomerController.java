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

    @PutMapping("/update-customer")
    public void upateCustomer(@RequestBody Customer customer){
        service.update(customer);
    }

    @DeleteMapping("/delete-customer/{id}")
    public void delete(@PathVariable Integer id){
         service.deleteCustomer(id);
    }

    @GetMapping("/search-customer/{id}")
    public Customer search(@PathVariable Integer id){
        return service.searchCustomer(id);
    }
}
