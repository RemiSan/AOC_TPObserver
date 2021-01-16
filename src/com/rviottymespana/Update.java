package com.rviottymespana;

public class Update implements MethodInvocation {

    Afficheur afficheur;
    CapteurAsync capteurAsync;

    public Update(Afficheur afficheur, CapteurAsync capteurAsync) {
        this.afficheur = afficheur;
        this.capteurAsync = capteurAsync;
    }

    @Override
    public void call() {
        this.afficheur.update(capteurAsync);
    }
}
