package com.neiron.neiron.crud;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ResponceStatus {
    OK("ok"),
    ERROR("error"),
    PENDING("pending"),
    NO_AUTH("no.auth");
    private final String strVal;

    ResponceStatus(String strVal) {
        this.strVal = strVal;
    }

    @JsonValue
    public String val() {
        return strVal;
    }

} 