package com.neiron.neiron.utils.aliska;

import com.neiron.neiron.repos.BulbColorRepo;
import com.neiron.neiron.repos.BulbTypeRepo;
import com.neiron.neiron.repos.ConnectorTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBParser {
    @Autowired
    ConnectorTypeRepo connectorTypeRepo;
    @Autowired
    BulbColorRepo bulbColorRepo;
    @Autowired
    BulbTypeRepo bulbTypeRepo;

    public Integer getConnectorType(String word) {
        return connectorTypeRepo.findBySinonim(word).getId();
    }

    public Integer getBulbColor(String word) {
        return bulbColorRepo.findBySinonim(word).getId();
    }

    public Integer getBulbType(String word) {
        return bulbTypeRepo.findBySinonim(word).getId();
    }
}