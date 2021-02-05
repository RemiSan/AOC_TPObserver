package com.rviottymespana.algosdiffusion;

import com.rviottymespana.Canal;
import com.rviottymespana.Capteur;
import com.rviottymespana.ObserverDeCapteurAsync;

/**
 * Interface publique représentant un algorithme de diffusion générique
 */
public interface AlgoDiffusion{

    /**
     * Permet de mettre en place le Capteur à utiliser par l'algorithme
     * @param capteur Capteur à utiliser par l'algorithme
     */
    void configure(Capteur capteur);

    /**
     * Permet de lancer l'execution de l'algorithme
     */
    void execute();

    /**
     * Permet de signaler lorsque la valeur d'un capteur se fait lire
     * @param observerDeCapteurAsync Observer par lequel la demande de lecture est parvenue à l'algorithme
     */
    void valueRead(ObserverDeCapteurAsync observerDeCapteurAsync);
}
