package com.rviottymespana;

import java.util.ArrayList;
import java.util.List;

public class CapteurImpl implements Capteur{

    AlgoDiffusion algo;
    Integer value;
    List<ObserverDeCapteurAsync> observerDeCapteurs = new ArrayList<>();

    public CapteurImpl(AlgoDiffusion algo) {
        this.algo = algo;
        this.algo.configure(this);
    }

    @Override
    public Integer getValue(ObserverDeCapteurAsync observerDeCapteurAsync) {
        algo.valueRead(this);
        return value;
    }

    @Override
    public void tick() {
        value++;
        algo.execute();
    }

    @Override
    public void lock() {
        //timer.stop();
    }


    @Override
    public void unlock() {
        //timer.start()
    }

    @Override
    public void attach(ObserverDeCapteurAsync o) {
        observerDeCapteurs.add(o);
    }

    @Override
    public void detach(ObserverDeCapteurAsync o) {
        observerDeCapteurs.remove(o);
    }
}
