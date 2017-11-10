package com.neiron.neiron.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Price {
    @Id
    @GeneratedValue
    public Long id;

    @Column(name = "customerAliskaId")
    public Long customerAliskaId;

    @Column(name = "priceName")
    public String priceName;

    @Column(name = "allVisible")
    public Boolean allVisible;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerAliskaId() {
        return customerAliskaId;
    }

    public void setCustomerAliskaId(Long customerAliskaId) {
        this.customerAliskaId = customerAliskaId;
    }

    public String getPriceName() {
        return priceName;
    }

    public void setPriceName(String priceName) {
        this.priceName = priceName;
    }

    public Boolean getAllVisible() {
        return allVisible;
    }

    public void setAllVisible(Boolean allVisible) {
        this.allVisible = allVisible;
    }
}