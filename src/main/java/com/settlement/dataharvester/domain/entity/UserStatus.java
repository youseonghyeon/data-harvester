package com.settlement.dataharvester.domain.entity;

public enum UserStatus {

    ACTIVE;

    public static UserStatus getDefaultStatus() {
        return ACTIVE;
    }
}
