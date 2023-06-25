package com.tcs.certificacion.enums;

public enum Constants {
    EMAIL("email"),
    PASSWORD("password");

    private final String constant;

    Constants(String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }
}
