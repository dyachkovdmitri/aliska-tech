package com.neiron.neiron.repos;

import com.neiron.neiron.entities.ConnectorType;
import com.neiron.neiron.entities.CustomerRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRequestRepo extends JpaRepository<CustomerRequest, Long>, JpaSpecificationExecutor<Long> {//                       extends CrudRepository<CustomerRequest,Long> {
}

