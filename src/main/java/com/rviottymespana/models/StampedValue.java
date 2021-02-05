package com.rviottymespana.models;

/**
 * Modèle représentant une valeur estampillée
 */
public class StampedValue {

    // Valeur
    Integer value;

    // Estampille correspondant à la date de captation de la valeur
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
