package com.neiron.neiron.repos;

import com.neiron.neiron.entities.Test;
import org.springframework.data.repository.CrudRepository;

public interface TestRepo extends CrudRepository<Test,Long> {
} 