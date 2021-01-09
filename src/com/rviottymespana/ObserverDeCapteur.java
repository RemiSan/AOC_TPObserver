package com.rviottymespana;

import java.util.concurrent.Future;

public interface ObserverDeCapteur {
    Future<?> update(Capteur capteur);

}
