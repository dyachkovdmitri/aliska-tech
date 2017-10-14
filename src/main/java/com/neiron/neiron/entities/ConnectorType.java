package com.neiron.neiron.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ConnectorType {
    @Id
    @GeneratedValue
    public Integer id;
    @Column(name = "sinonymes")
    String sinonymes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSinonymes() {
        return sinonymes;
    }

    public void setSinonymes(String sinonymes) {
        this.sinonymes = sinonymes;
    }
}