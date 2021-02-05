package com.rviottymespana;

import com.rviottymespana.algosdiffusion.AlgoDiffusion;
import com.rviottymespana.models.StampedValue;

import java.util.List;

/**
 * Interface publique représentant un capteur
 */
public interface Capteur extends Cloneable{

    /**
     * @return la liste des observers du capteur
     */
    List<ObserverDeCapteurAsync> getObserverDeCapteurs();

    /**
     * Permet d'obtenir la valeur actuelle du Capteur
     * @param observerDeCapteurAsync Observer par lequel la demande de lecture est parvenue au capteur
     * @return valeur actuelle du Capteur estampillée
     */
    StampedValue getValue(ObserverDeCapteurAsync observerDeCapteurAsync);

    /**
     * Permet de mettre en place l'algorithme de diffusion à ultiliser pour la diffusion des valeurs
     * du capteur
     * @param algoDiffusion Algorithme de diffusion à utiliser
     */
    void configure(AlgoDiffusion algoDiffusion);

    /**
     * Permet d'incrémenter de la valeur du capteur
     */
    void tick();

    /**
     * Permet de verrouiller le capteur, lorsque le capteur est verrouillé, sa valeur ne
     * peut plus être incrémentée (via tick())
     */
    void lock();

    /**
     * Permet de déverrouiller le capteur, sa valeur pourra alors être incrémentée à nouveau (via tick())
     */
    void unlock();

    /**
     * Permet d'attacher un observer au capteur
     * @param observerDeCapteurAsync Observer à attacher au capteur
     */
    void attach(ObserverDeCapteurAsync observerDeCapteurAsync);

    /**
     * Permet de cloner le capteur
     * @return clone du capteur
     */
    Capteur clone();
}
