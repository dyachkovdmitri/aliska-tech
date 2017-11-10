package com.neiron.neiron.repos;

import com.neiron.neiron.entities.CustomerRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface CustomerRequestRepo extends JpaRepository<CustomerRequest, Long>, JpaSpecificationExecutor<Long> {//                       extends CrudRepository<CustomerRequest,Long> {
}

