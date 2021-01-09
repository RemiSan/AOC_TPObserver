package com.rviottymespana;

import java.util.concurrent.Future;

public interface ObserverDeCapteurAsync {
    Future<?> update(Capteur capteur);
}
