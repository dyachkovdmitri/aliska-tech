package com.neiron.neiron.repos;

import com.neiron.neiron.entities.Company;
import com.neiron.neiron.entities.ConnectorType;
import com.neiron.neiron.entities.RequestLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepo extends JpaRepository<Company, Long>, JpaSpecificationExecutor<Long> {
} 