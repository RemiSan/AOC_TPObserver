package com.rviottymespana.algosdiffusion;

import com.rviottymespana.Capteur;
import com.rviottymespana.ObserverDeCapteurAsync;

import java.util.HashSet;
import java.util.Set;

/**
 * Classe représentant l'algorithme de diffusion atomique
 * Il s'agit d'une Concrete Strategy dans le patron de conception Strategy
 */
public class DiffusionAtomique implements AlgoDiffusion{

    Capteur capteur;

    /**
     * Ensemble représentant les observers ayant lu la valeur après la dernière phase d'écriture
     */
    Set<ObserverDeCapteurAsync> observersDone = new HashSet<>();

    @Override
    public void configure(Capteur capteur) {
        this.capteur = capteur;
    }

    @Override
    public void execute() {
        capteur.lock();
        observersDone.clear();
        for (ObserverDeCapteurAsync canal : capteur.getObserverDeCapteurs()){
            canal.update(capteur);
        }
    }

    @Override
    public void valueRead(ObserverDeCapteurAsync observerDeCapteurAsync) {
        observersDone.add(observerDeCapteurAsync);
        // Lorsque tous les observers ont lu la valeur, on débloque le capteur (on autorise l'écriture)
        if (observersDone.containsAll(capteur.getObserverDeCapteurs())) {
            capteur.unlock();
        }
    }
}
