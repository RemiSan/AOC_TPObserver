package com.rviottymespana;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//sera public class Canal implements ObserverDeCapteurAsync, CapteurAsync{
//joue le role de proxy entre afficheur et capteur, en ralentissant la diffusion des messages
public class Canal implements ObserverDeCapteur, Capteur{

    ScheduledExecutorService scheduler;
    ObserverDeCapteur afficheur;
    Capteur subject;

    public Canal(ScheduledExecutorService scheduler, Afficheur afficheur) {
        this.scheduler = scheduler;
        attach(afficheur);
    }



    @Override
    public Future<?> update(Capteur subject) {
        this.subject = subject;
        return scheduler.schedule(() -> afficheur.update(subject),(int)(Math.random() * 2000), TimeUnit.MILLISECONDS);
    }

    @Override
    public Integer getValue(ObserverDeCapteur observerDeCapteur) {
        return this.subject.getValue(this);
    }

    // doit être appelé par un ScheduleExecutorService
    @Override
    public void tick() {
    }

    @Override
    public void lock() {
        // empeche de modifier la valeur
    }

    @Override
    public void unlock() {
        // lance l'incrémentation
    }

    @Override
    public void attach(ObserverDeCapteur o) {
        afficheur = o;
    }

    @Override
    public void detach(ObserverDeCapteur o) {

    }
}
