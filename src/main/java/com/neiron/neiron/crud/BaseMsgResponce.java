package com.neiron.neiron.crud;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;


@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class BaseMsgResponce<E> extends BaseResponce {
    private String msg;
    private ArrayList<E> data;
    private String aliskaMonolog;

    public String getAliskaMonolog() {
        return aliskaMonolog;
    }

    public void setAliskaMonolog(String aliskaMonolog) {
        this.aliskaMonolog = aliskaMonolog;
    }

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

    public void setData(E data) {
        ArrayList<E> datas = new ArrayList<>();
        datas.add(data);
        this.data = datas;
    }

    public ArrayList<E> getData() {
        return data;
    }

    public void setData(ArrayList<E> data) {
        this.data = data;
    }

    public BaseMsgResponce( ) {

        super();
    }//todo?

}
