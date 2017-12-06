package com.neiron.neiron.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Customer {
    @Id
    public Long id;
    @Column(name = "name")
    String name;
    @Column(name = "ammount")
    Integer ammount;
    @Column(name = "random")
    String random;
    @Column(name = "checked")
    Boolean checked;
    @Column(name = "aliskaMonolog")
    String aliskaMonolog;



    public String getRandom() {
        return random;
    }

    public String getAliskaMonolog() {
        return aliskaMonolog;
    }

    public void setAliskaMonolog(String aliskaMonolog) {
        this.aliskaMonolog = aliskaMonolog;
    }

    public void setRandom(String random) {
        this.random = random;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmmount() {
        return ammount;
    }

    public void setAmmount(Integer ammount) {
        this.ammount = ammount;
    }


    @Override
    public String toString() {
        return name+","+ammount;
    }

    public void addAliskaMonolog(String monolog) {
        this.setAliskaMonolog(this.getAliskaMonolog()+monolog);
    }
}