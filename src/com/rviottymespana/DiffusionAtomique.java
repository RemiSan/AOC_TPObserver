package com.rviottymespana;

import java.util.List;

public class DiffusionAtomique implements AlgoDiffusion{

    Capteur capteur;
    List<ObserverDeCapteurAsync> canalList;
    Integer canalDone;

    public DiffusionAtomique() {
    }

    @Override
    public void configure(Capteur capteur) {
        this.capteur = capteur;
    }

    @Override
    public void execute() {
        capteur.lock();
        canalDone = 0;
        for (ObserverDeCapteurAsync canal : canalList){
            canal.update(capteur);
        }
    }

    @Override
    public void valueRead(Capteur capteur) {
        canalDone++;
        if (canalDone == canalList.size()) {
            capteur.unlock();
        }
    }
}
