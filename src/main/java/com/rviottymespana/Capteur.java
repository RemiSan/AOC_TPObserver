package com.rviottymespana;

import com.rviottymespana.algosdiffusion.AlgoDiffusion;
import com.rviottymespana.models.StampedValue;

public interface Capteur extends Cloneable{
    StampedValue getValue(ObserverDeCapteurAsync observerDeCapteurAsync);
    void configure(AlgoDiffusion algoDiffusion);
    void tick();
    void lock();
    void unlock();
    void attach(ObserverDeCapteurAsync o);
    void detach(ObserverDeCapteurAsync o);
    Capteur clone();
}
