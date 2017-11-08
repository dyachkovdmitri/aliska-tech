package com.neiron.neiron.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CustomerRequest {
    @Id
    @GeneratedValue
    public Long id;

    @Column(name = "dateRequest")
    Long dateRequest;

    @Column(name = "customerAliskaId")
    Long customerAliskaId;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "name")
    String name;

    @Column(name = "status")
    Integer status; //1 - только получено // 2 заполнены колонки unparsed/ 3-заполнена колонки parsed //4- заполнены id // 5-отправлено

    @Column(name = "commentary")
    String commentary;

    public Long getId() {
        return id;
    }

    public Long getCustomerAliskaId() {
        return customerAliskaId;
    }

    public void setCustomerAliskaId(Long customerAliskaId) {
        this.customerAliskaId = customerAliskaId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDateRequest() {
        return dateRequest;
    }

    public void setDateRequest(Long dateRequest) {
        this.dateRequest = dateRequest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }
}