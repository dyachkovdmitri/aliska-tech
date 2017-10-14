package com.neiron.neiron.repos;

import com.neiron.neiron.entities.BulbType;
import com.neiron.neiron.entities.ConnectorType;
import com.neiron.neiron.entities.Test;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BulbTypeRepo extends CrudRepository<BulbType, Long> {
    @Query("Select bt FROM BulbType bt where bt.sinonymes like '%:word%'")
    ConnectorType findBySinonim(@Param("word") String word);
}
