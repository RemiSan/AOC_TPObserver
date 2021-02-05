package com.rviottymespana;

/**
 * Interface publique représentant un observeur de capteur
 */
public interface ObserverDeCapteur {

    /**
     * Permet de signaler que la valeur d'un observable observé par l'observer
     * a été modifiée
     * @param capteurAsync Observable dont la valeur a changé
     */
    void update(CapteurAsync capteurAsync);
}
