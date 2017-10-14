package com.neiron.neiron.repos;

import com.neiron.neiron.entities.RequestLine;
import com.neiron.neiron.entities.Test;
import org.springframework.data.repository.CrudRepository;

public interface RequestLineRepo extends CrudRepository<RequestLine,Long> {
} 