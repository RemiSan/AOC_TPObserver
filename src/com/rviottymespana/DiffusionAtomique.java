package com.rviottymespana;

public class DiffusionAtomique implements AlgoDiffusion{

    Capteur capteur;
    Canal canal;

    public DiffusionAtomique(Capteur capteur, Canal canal) {
        this.capteur = capteur;
        this.canal = canal;
    }

    @Override
    public void configure() {

    }

    @Override
    public void execute() {
        capteur.lock();
        canal.update(capteur);
    }
}
