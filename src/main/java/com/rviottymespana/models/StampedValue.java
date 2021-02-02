package com.rviottymespana.models;

public class StampedValue {

    Integer value;
    long timestamp;

    public StampedValue(Integer value, long timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }

    public Integer getValue() {
        return value;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
