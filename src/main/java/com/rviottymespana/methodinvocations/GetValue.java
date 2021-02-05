package com.rviottymespana.methodinvocations;

import com.rviottymespana.Capteur;
import com.rviottymespana.ObserverDeCapteurAsync;
import com.rviottymespana.models.StampedValue;

import java.util.concurrent.Callable;

/**
 * Concrete method invocation : permet de faire un getValue() sur le capteur
 */
public class GetValue implements Callable<StampedValue> {

    private final Capteur capteur;
    private final ObserverDeCapteurAsync observerDeCapteurAsync;

    public GetValue(Capteur capteur, ObserverDeCapteurAsync observerDeCapteurAsync) {
        this.capteur = capteur;
        this.observerDeCapteurAsync = observerDeCapteurAsync;
    }

    @Override
    public StampedValue call() {
        return this.capteur.getValue(observerDeCapteurAsync);
    }
}
