package org.example.exception;

public enum Entity {
    DELIVERY_EMPLOYEE;

    public String getEntity() {
        return name().toLowerCase();
    }
}
