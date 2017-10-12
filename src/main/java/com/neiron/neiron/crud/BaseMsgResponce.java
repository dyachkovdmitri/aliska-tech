package com.neiron.neiron.crud;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class BaseMsgResponce extends BaseResponce {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BaseMsgResponce(ResponceStatus status, String msg) {
        super(status);
        this.msg = msg;
    }

    public BaseMsgResponce( ) {
        super();
    }//todo?

}
