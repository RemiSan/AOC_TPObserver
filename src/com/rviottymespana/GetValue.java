package com.rviottymespana;

import java.util.concurrent.Callable;

public class GetValue implements Callable<Integer> {

    private Capteur capteur;
    private ObserverDeCapteurAsync observerDeCapteurAsync;

    public GetValue(Capteur capteur, ObserverDeCapteurAsync observerDeCapteurAsync) {
        this.capteur = capteur;
        this.observerDeCapteurAsync = observerDeCapteurAsync;
    }

    @Override
    public Integer call() {
        return this.capteur.getValue(this.observerDeCapteurAsync);
    }
}
