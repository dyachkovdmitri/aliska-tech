package com.neiron.neiron.repos;

import com.neiron.neiron.entities.Item;
import com.neiron.neiron.entities.Test;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepo extends CrudRepository<Item,Long> {
} 