package com.neiron.neiron.crud;

import java.util.ArrayList;

public class ListComment<E> {
    String aliskaMonolog;
    ArrayList<E> data;

    public String getAliskaMonolog() {
        return aliskaMonolog;
    }

    public void setAliskaMonolog(String aliskaMonolog) {
        this.aliskaMonolog = aliskaMonolog;
    }

    public void addAliskaMonolog(String aliskaMonolog) {
        if (this.aliskaMonolog == null) {
            this.aliskaMonolog = "";
        }
        this.aliskaMonolog = this.aliskaMonolog + " " + aliskaMonolog;
    }

    public ArrayList<E> getData() {
        return data;
    }

    public void setData(ArrayList<E> data) {
        this.data = data;
    }

}