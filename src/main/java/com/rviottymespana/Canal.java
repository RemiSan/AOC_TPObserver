package com.rviottymespana;

import com.rviottymespana.methodinvocations.GetValue;
import com.rviottymespana.methodinvocations.Update;
import com.rviottymespana.models.StampedValue;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Canal implements ObserverDeCapteurAsync, CapteurAsync{

    ScheduledExecutorService scheduler;
    ObserverDeCapteur afficheur;
    Capteur subject;

    public Canal(ScheduledExecutorService scheduler, Afficheur afficheur) {
        this.scheduler = scheduler;
        this.afficheur = afficheur;
    }

    @Override
    public Future<?> update(Capteur subject) {
        this.subject = subject;
        Update update = new Update(afficheur, this);
        return scheduler.schedule(update, (int)(Math.random() * 2000), TimeUnit.MILLISECONDS);
    }

    @Override
    public Future<StampedValue> getValue() {
        GetValue getValue = new GetValue(this.subject, this);
        return scheduler.schedule(getValue, (int)(Math.random() * 2000), TimeUnit.MILLISECONDS);
    }
}
