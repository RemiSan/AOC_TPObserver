package com.rviottymespana.algosdiffusion;

import com.rviottymespana.Capteur;
import com.rviottymespana.ObserverDeCapteurAsync;

import java.util.HashSet;
import java.util.Set;

public class DiffusionSequentielle implements AlgoDiffusion{

    Capteur capteur;
    Set<ObserverDeCapteurAsync> observersDone = new HashSet<>();
    boolean reading = false;

    @Override
    public void configure(Capteur capteur) {
        this.capteur = capteur;
    }

    @Override
    public void execute() {
        if (!reading) {
            observersDone.clear();
            reading = true;
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
