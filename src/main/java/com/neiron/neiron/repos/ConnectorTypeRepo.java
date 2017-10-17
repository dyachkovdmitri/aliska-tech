package com.neiron.neiron.repos;

import com.neiron.neiron.entities.ConnectorType;
import com.neiron.neiron.entities.Test;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ConnectorTypeRepo extends CrudRepository<ConnectorType, Long> {
    @Query("Select ct FROM ConnectorType ct where ct.sinonymes like :word")
    ConnectorType findBySinonim(@Param("word") String word);
}