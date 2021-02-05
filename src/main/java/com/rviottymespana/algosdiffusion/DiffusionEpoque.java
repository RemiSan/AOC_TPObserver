package com.rviottymespana.algosdiffusion;

import com.rviottymespana.Capteur;
import com.rviottymespana.CapteurImpl;
import com.rviottymespana.ObserverDeCapteurAsync;

/**
 * Classe représentant la gestion par époque
 * Il s'agit d'une Concrete Strategy dans le patron de conception Strategy
 */
public class DiffusionEpoque implements AlgoDiffusion {

    Capteur capteur;

    @Override
    public void configure(Capteur capteur) {
        this.capteur = capteur;
    }

    @Override
    public void execute() {
        for (ObserverDeCapteurAsync canal : capteur.getObserverDeCapteurs()){
            canal.update(capteur);
        }
    }

    @Override
    public void valueRead(ObserverDeCapteurAsync observerDeCapteurAsync) { }
}
