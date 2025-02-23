package org.example.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Customer;
import org.example.entity.CustomerEntity;
import org.example.reporsitory.CustomerDao;
import org.example.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    final CustomerDao customerDao;
    final ModelMapper mapper;

    @Override
    public void saveCustomer(Customer customer) {
        customerDao.save(mapper.map(customer, CustomerEntity.class));
    }

    @Override
    public List<Customer> getAll() {
        List<CustomerEntity> customerEntities = customerDao.findAll();
        List<Customer> customerList = new ArrayList<>();

        customerEntities.forEach(customerEntity ->
            customerList.add(mapper.map(customerEntity, Customer.class))
        );
        return customerList;
    }

    @Override
    public void update(Customer customer) {
        customerDao.save(mapper.map(customer, CustomerEntity.class));
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerDao.deleteById(id);
    }

    @Override
    public Customer searchCustomer(Integer id) {
        Optional<CustomerEntity> customerEntity = customerDao.findById(id);

        return mapper.map(customerEntity, Customer.class);

    }
}
