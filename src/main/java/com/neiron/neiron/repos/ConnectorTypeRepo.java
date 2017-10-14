package com.neiron.neiron.repos;

import com.neiron.neiron.entities.ConnectorType;
import com.neiron.neiron.entities.Test;
import org.springframework.data.repository.CrudRepository;

public interface ConnectorTypeRepo extends CrudRepository<ConnectorType,Long> {
} 