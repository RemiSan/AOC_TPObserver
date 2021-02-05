package com.rviottymespana;

import java.util.concurrent.Future;

/**
 * Interface publique représentant un observeur asynchrone de capteur
 */
public interface ObserverDeCapteurAsync {

    /**
     * Permet de signaler de manière asynchrone que la valeur d'un
     * observable observé par l'observer a été modifiée
     * @param capteur Observable dont la valeur a changé
     */
    Future<?> update(Capteur capteur);
}
