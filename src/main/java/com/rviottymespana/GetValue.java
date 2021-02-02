package com.rviottymespana;

import com.rviottymespana.models.StampedValue;

import java.util.concurrent.Callable;

public class GetValue implements Callable<StampedValue> {

    private Capteur capteur;
    private ObserverDeCapteurAsync observerDeCapteurAsync;

    public GetValue(Capteur capteur, ObserverDeCapteurAsync observerDeCapteurAsync) {
        this.capteur = capteur;
        this.observerDeCapteurAsync = observerDeCapteurAsync;
    }

    @Override
    public StampedValue call() {
        return this.capteur.getValue(this.observerDeCapteurAsync);
    }
}
