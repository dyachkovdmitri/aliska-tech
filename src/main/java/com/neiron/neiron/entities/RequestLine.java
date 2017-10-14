package com.neiron.neiron.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RequestLine {
    @Id
    @GeneratedValue
    public Long id;

    @Column(name = "requestId")
    Long requestId;

    @Column(name = "unparsedLine")
    String unparsedLine;

    @Column(name = "parsedLine")
    String parsedLine;

    @Column(name = "assortmentId")
    String assortmentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getUnparsedLine() {
        return unparsedLine;
    }

    public void setUnparsedLine(String unparsedLine) {
        this.unparsedLine = unparsedLine;
    }

    public String getParsedLine() {
        return parsedLine;
    }

    public void setParsedLine(String parsedLine) {
        this.parsedLine = parsedLine;
    }

    public String getAssortmentId() {
        return assortmentId;
    }

    public void setAssortmentId(String assortmentId) {
        this.assortmentId = assortmentId;
    }
}