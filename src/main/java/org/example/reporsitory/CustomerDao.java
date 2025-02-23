package org.example.reporsitory;

import org.example.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<CustomerEntity,Integer> {

}
