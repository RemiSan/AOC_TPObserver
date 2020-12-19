package com.rviottymespana;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class App {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        Capteur capteur;
        AlgoDiffusion strategy;
        Canal c1,c2,c3,c4;
        Afficheur a1,a2,a3,a4;
    }
}
