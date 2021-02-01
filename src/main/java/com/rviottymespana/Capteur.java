package com.rviottymespana;

public interface Capteur extends Cloneable{
    Integer getValue(ObserverDeCapteurAsync observerDeCapteurAsync);
    void configure(AlgoDiffusion algoDiffusion);
    void tick();
    void lock();
    void unlock();
    void attach(ObserverDeCapteurAsync o);
    void detach(ObserverDeCapteurAsync o);
    Capteur clone();
}
