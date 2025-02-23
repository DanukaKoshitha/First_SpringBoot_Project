package org.example.service;

import org.example.dto.Customer;

import java.util.List;

public interface CustomerService{
    void saveCustomer(Customer customer);

    List<Customer> getAll();

    void update(Customer customer);

    void deleteCustomer(Integer id);

    Customer searchCustomer(Integer id);
}
