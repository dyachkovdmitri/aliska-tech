package com.neiron.neiron.repos;

import com.neiron.neiron.entities.Item;
import com.neiron.neiron.entities.RequestLine;
import com.neiron.neiron.entities.Test;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ItemRepo extends CrudRepository<Item, Long> {
    ArrayList<Item> findByCompanyId(Long companyId);
} 