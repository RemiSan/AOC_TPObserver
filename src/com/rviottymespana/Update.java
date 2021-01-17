package com.rviottymespana;

import java.util.concurrent.Callable;

public class Update implements Callable<Void> {

    ObserverDeCapteur afficheur;
    CapteurAsync capteurAsync;

    public Update(ObserverDeCapteur afficheur, CapteurAsync capteurAsync) {
        this.afficheur = afficheur;
        this.capteurAsync = capteurAsync;
    }

    @Override
    public Void call() {
        this.afficheur.update(capteurAsync);
        return null;
    }
}
