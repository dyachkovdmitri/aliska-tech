package com.neiron.neiron.repos;

import com.neiron.neiron.entities.BulbColor;
import com.neiron.neiron.entities.ConnectorType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BulbColorRepo extends CrudRepository<BulbColor,Long> {
    @Query("Select bc FROM BulbColor bc where bc.sinonymes like '%:word%'")
    ConnectorType findBySinonim(@Param("word")String word );}
