package com.rviottymespana;

public interface Capteur {
    Integer getValue(ObserverDeCapteurAsync observerDeCapteurAsync);
    void tick();
    void lock();
    void unlock();
    void attach(ObserverDeCapteurAsync o);
    void detach(ObserverDeCapteurAsync o);
}
