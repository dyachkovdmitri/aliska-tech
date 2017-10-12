package com.neiron.neiron.crud;

public class BaseResponce {
    private ResponceStatus status;
    public static final BaseResponce OK = new BaseResponce(ResponceStatus.OK);
    public static final BaseResponce ERROR = new BaseResponce(ResponceStatus.ERROR);
    public static final BaseResponce PENDING = new BaseResponce(ResponceStatus.PENDING);
    public BaseResponce() {
    }
    public BaseResponce(ResponceStatus status) {
        this.status = status;
    }

    public ResponceStatus getStatus() {
        return status;
    }

    public void setStatus(ResponceStatus status) {
        this.status = status;
    }
} 