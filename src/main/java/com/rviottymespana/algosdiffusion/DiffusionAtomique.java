package com.rviottymespana.algosdiffusion;

import com.rviottymespana.CapteurImpl;
import com.rviottymespana.ObserverDeCapteurAsync;

public class DiffusionAtomique implements AlgoDiffusion{

    CapteurImpl capteur;
    Integer canalDone;

    public DiffusionAtomique() {
    }

    @Override
    public void configure(CapteurImpl capteur) {
        this.capteur = capteur;
    }

    @Override
    public void execute() {
        capteur.lock();
        canalDone = 0;
        for (ObserverDeCapteurAsync canal : capteur.getObserverDeCapteurs()){
            canal.update(capteur);
        }
    }

    @Override
    public void valueRead(CapteurImpl capteur) {
        canalDone++;
        if (canalDone == capteur.getObserverDeCapteurs().size()) {
            capteur.unlock();
        }
    }
}
