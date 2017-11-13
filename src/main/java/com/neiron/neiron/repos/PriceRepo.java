package com.neiron.neiron.repos;


import com.neiron.neiron.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.ArrayList;


public interface PriceRepo extends JpaRepository<Price, Long>, JpaSpecificationExecutor<Long> {
    ArrayList<Price> getByCustomerAliskaId(Long customerAliskaId);
    ArrayList<Price>  findByCustomerAliskaIdAndId (Long customerAliskaId, Long Id);
} 