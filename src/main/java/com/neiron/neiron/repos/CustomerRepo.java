package com.neiron.neiron.repos;

import com.neiron.neiron.entities.Customer;
import com.neiron.neiron.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustomerRepo extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Long> {
    public Customer findById(Long id);
} 