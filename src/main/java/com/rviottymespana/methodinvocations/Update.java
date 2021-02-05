package com.rviottymespana.methodinvocations;

import com.rviottymespana.CapteurAsync;
import com.rviottymespana.ObserverDeCapteur;

import java.util.concurrent.Callable;

/**
 * Concrete method invocation : permet de faire un update() sur l'afficheur
 */
public class Update implements Callable<Void> {

    private final ObserverDeCapteur afficheur;
    private final CapteurAsync capteurAsync;

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
