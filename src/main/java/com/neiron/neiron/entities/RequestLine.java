package com.neiron.neiron.entities;

import javax.persistence.*;

@Entity
public class RequestLine {
    @Id
    @GeneratedValue
    public Long id;

    @Column(name = "requestId")
    private Long requestId;

    @Column(name = "unparsedLine")
    private String unparsedLine;

    @Column(name = "ammount")
    private Integer ammount;

    @Column(name = "parsedLine")
    private String parsedLine;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "assortmentId")
    private Item assortmentId;

//    @Column(name = "assortmentId")
//    private Long assortmentId;

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

    public Item getAssortmentId() {
        return assortmentId;
    }

    public void setAssortmentId(Item assortmentId) {
        this.assortmentId = assortmentId;
    }

    public Integer getAmmount() {
        return ammount;
    }

    public void setAmmount(Integer ammount) {
        this.ammount = ammount;
    }
}