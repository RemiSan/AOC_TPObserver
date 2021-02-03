package com.rviottymespana;

import com.rviottymespana.algosdiffusion.AlgoDiffusion;
import com.rviottymespana.models.StampedValue;

import java.util.List;

public interface Capteur extends Cloneable{

    /**
     * @return la liste des observers du capteur
     */
    List<ObserverDeCapteurAsync> getObserverDeCapteurs();

    StampedValue getValue(ObserverDeCapteurAsync observerDeCapteurAsync);
    void configure(AlgoDiffusion algoDiffusion);
    void tick();
    void lock();
    void unlock();
    void attach(ObserverDeCapteurAsync o);
    Capteur clone();
}
