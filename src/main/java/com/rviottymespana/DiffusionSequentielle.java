package com.rviottymespana;

public class DiffusionSequentielle implements AlgoDiffusion{

    CapteurImpl capteur;
    Integer canalDone;
    boolean reading = false;

    public DiffusionSequentielle() {
    }

    @Override
    public void configure(CapteurImpl capteur) {
        this.capteur = capteur;
    }

    @Override
    public void execute() {
        if (!reading) {
            canalDone = 0;
            reading = true;
            Capteur clone = capteur.clone();
            for (ObserverDeCapteurAsync canal : capteur.getObserverDeCapteurs()) {
                canal.update(clone);
            }
        }
    }

    @Override
    public void valueRead(CapteurImpl capteur) {
        canalDone++;
        if (canalDone == capteur.getObserverDeCapteurs().size()) {
            reading = false;
        }
    }
}
