package com.rviottymespana.algosdiffusion;

import com.rviottymespana.Capteur;
import com.rviottymespana.ObserverDeCapteurAsync;

import java.util.HashSet;
import java.util.Set;

public class DiffusionAtomique implements AlgoDiffusion{

    Capteur capteur;
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
        if (observersDone.containsAll(capteur.getObserverDeCapteurs())) {
            capteur.unlock();
        }
    }
}
