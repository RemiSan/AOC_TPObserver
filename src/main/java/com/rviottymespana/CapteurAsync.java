package com.rviottymespana;

import com.rviottymespana.models.StampedValue;

import java.util.concurrent.Future;

/**
 * Interface publique représentant un capteur asynchrone
 */
public interface CapteurAsync {
    /**
     * Permet d'obtenir la valeur actuelle du Capteur de manière asynchrone
     * @return Future qui contiendra la valeur du Capteur
     */
    Future<StampedValue> getValue();
}
