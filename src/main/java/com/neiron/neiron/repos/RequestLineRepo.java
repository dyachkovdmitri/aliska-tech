package com.neiron.neiron.repos;

import com.neiron.neiron.entities.CustomerRequest;
import com.neiron.neiron.entities.RequestLine;
import com.neiron.neiron.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface RequestLineRepo extends JpaRepository<RequestLine, Long>, JpaSpecificationExecutor<Long> {
    ArrayList<RequestLine> findByRequestId(Long requestId);
} 