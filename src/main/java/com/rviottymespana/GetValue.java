package com.rviottymespana;

import java.util.concurrent.Callable;

public class GetValue implements Callable<Void> {

    private Afficheur afficheur;
    private Capteur capteur;
    private ObserverDeCapteurAsync observerDeCapteurAsync;

    public GetValue(Capteur capteur, ObserverDeCapteurAsync observerDeCapteurAsync, Afficheur afficheur) {
        this.capteur = capteur;
        this.observerDeCapteurAsync = observerDeCapteurAsync;
        this.afficheur = afficheur;
    }

    @Override
    public Void call() {
        afficheur.getUpdated(this.capteur.getValue(this.observerDeCapteurAsync));
        return null;
    }
}
