package com.rviottymespana;

import java.util.concurrent.Future;

public interface CapteurAsync {
    Future<Integer> getValue();
    void tick();
    void lock();
    void unlock();
    void attach(ObserverDeCapteur o);
    void detach(ObserverDeCapteur o);
}
