package com.rviottymespana;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//sera public class Canal implements ObserverDeCapteurAsync, CapteurAsync{
public class Canal implements ObserverDeCapteur, Capteur{

    ScheduledExecutorService scheduler;
    Afficheur afficheur;

    public Canal(ScheduledExecutorService scheduler, Afficheur afficheur) {
        this.scheduler = scheduler;
        this.afficheur = afficheur;
    }



    @Override
    public Future<?> update(Capteur subject) {
        return scheduler.schedule(() -> afficheur.update(subject),1, TimeUnit.SECONDS);
    }

    @Override
    public Integer getValue() {
        return null;
    }

    // doit être appelé par un ScheduleExecutorService
    @Override
    public void tick() {

    }

    @Override
    public void lock() {

    }

    @Override
    public void attach(Observer o) {

    }

    @Override
    public void detach(Observer o) {

    }
}
