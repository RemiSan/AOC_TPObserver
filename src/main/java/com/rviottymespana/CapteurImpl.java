package com.rviottymespana;

import com.rviottymespana.algosdiffusion.AlgoDiffusion;
import com.rviottymespana.models.StampedValue;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CapteurImpl implements Capteur{


    private AlgoDiffusion algo;
    private Integer value;
    private final List<ObserverDeCapteurAsync> observerDeCapteurAsyncList = new ArrayList<ObserverDeCapteurAsync>();

    // Executor permettant d'appeler tick en boucle à un délai fixe
    private final ScheduledExecutorService executor;

    /**
     *  Verrou permettant de sauter l'incrémentation de value à l'appel de tick
     *  permet donc d'interdire l'écriture pour la diffusion atomique
     */
    private boolean locked;

    public CapteurImpl() {
        this.value = 0;
        this.executor = Executors.newSingleThreadScheduledExecutor();
        this.locked = false;
        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                tick();
            }
        };
        this.executor.scheduleAtFixedRate(repeatedTask, 1000L, 1000L, TimeUnit.MILLISECONDS);
    }

    @Override
    public List<ObserverDeCapteurAsync> getObserverDeCapteurs(){
        return observerDeCapteurAsyncList;
    }

    @Override
    public StampedValue getValue(ObserverDeCapteurAsync observerDeCapteurAsync) {
        algo.valueRead(observerDeCapteurAsync);
        return new StampedValue(value, System.currentTimeMillis());
    }

    @Override
    public void configure(AlgoDiffusion algoDiffusion) {
        this.algo = algoDiffusion;
        this.algo.configure(this);
    }

    @Override
    public void tick() {
        if (!locked) {
            value = CapteurUtils.calculateNextValue(value);
            algo.execute();
        }
    }

    @Override
    public void lock() {
        this.locked = true;
    }


    @Override
    public void unlock() {
        this.locked = false;
    }

    @Override
    public void attach(ObserverDeCapteurAsync o) {
        observerDeCapteurAsyncList.add(o);
    }

    @Override
    public Capteur clone() {
        try {
            return (Capteur) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
