package com.rviottymespana;

public class CapteurImpl implements Capteur{

    AlgoDiffusion algo;

    public CapteurImpl(AlgoDiffusion algo) {
        this.algo = algo;
    }

    @Override
    public Integer getValue() {
        return null;
    }

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
