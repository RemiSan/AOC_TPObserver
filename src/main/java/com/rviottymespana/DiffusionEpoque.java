package com.rviottymespana;

public class DiffusionEpoque implements AlgoDiffusion {

    CapteurImpl capteur;

    @Override
    public void configure(CapteurImpl capteur) {
        this.capteur = capteur;
    }

    @Override
    public void execute() {
        for (ObserverDeCapteurAsync canal : capteur.getObserverDeCapteurs()){
            canal.update(capteur);
        }
    }

    @Override
    public void valueRead(CapteurImpl capteur) { }
}
