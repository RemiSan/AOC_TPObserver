package com.rviottymespana.algosdiffusion;

import com.rviottymespana.Capteur;
import com.rviottymespana.ObserverDeCapteurAsync;

import java.util.HashSet;
import java.util.Set;

/**
 * Classe représentant l'algorithme de diffusion séquentielle
 * Il s'agit d'une Concrete Strategy dans le patron de conception Strategy
 */
public class DiffusionSequentielle implements AlgoDiffusion{

    private Capteur capteur;

    // Ensemble représentant les observers ayant lu la valeur après la dernière phase d'écriture
    private Set<ObserverDeCapteurAsync> observersDone = new HashSet<>();
    private boolean reading = false;

    @Override
    public void configure(Capteur capteur) {
        this.capteur = capteur;
    }

    @Override
    public void execute() {
        if (!reading) {
            observersDone.clear();
            reading = true;

            /**
             * on copie l'original dans la variable clone et les getValue() retourne la valeur du clone
             * pendant le que le capteur original continue d'incrémenter sa valeur
             */
            Capteur clone = capteur.clone();
            for (ObserverDeCapteurAsync canal : capteur.getObserverDeCapteurs()) {
                canal.update(clone);
            }
        }
    }

    @Override
    public void valueRead(ObserverDeCapteurAsync observerDeCapteurAsync) {
        observersDone.add(observerDeCapteurAsync);
        if (observersDone.containsAll(capteur.getObserverDeCapteurs())) {
            reading = false;
        }
    }
}
