package com.rviottymespana;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CapteurImpl implements Capteur{


    private final AlgoDiffusion algo;
    private Integer value;
    private final List<ObserverDeCapteurAsync> observerDeCapteurAsyncList = new ArrayList<>();
    private final ScheduledExecutorService executor;
    private final TimerTask repeatedTask = new TimerTask() {
        public void run() {
            tick();
        }
    };

    public CapteurImpl(AlgoDiffusion algo) {
        this.value = 0;
        this.algo = algo;
        this.algo.configure(this);
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }

    public List<ObserverDeCapteurAsync> getObserverDeCapteurs(){
        return observerDeCapteurAsyncList;
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
        this.executor.shutdown();
    }


    @Override
    public void unlock() {
        this.executor.scheduleAtFixedRate(repeatedTask, 1000L, 1000L, TimeUnit.MILLISECONDS);
    }

    @Override
    public void attach(ObserverDeCapteurAsync o) {
        observerDeCapteurAsyncList.add(o);
    }

    @Override
    public void detach(ObserverDeCapteurAsync o) {
        observerDeCapteurAsyncList.remove(o);
    }
}
