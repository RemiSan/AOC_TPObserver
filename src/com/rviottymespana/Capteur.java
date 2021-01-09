package com.rviottymespana;

public interface Capteur {
    Integer getValue(ObserverDeCapteur observerDeCapteur);
    void tick();
    void lock();
    void unlock();
    void attach(ObserverDeCapteur o);
    void detach(ObserverDeCapteur o);
}
