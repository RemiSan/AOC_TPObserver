package com.rviottymespana;



import ch.qos.logback.classic.BasicConfigurator;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class App {

    public static void main(String[] args) {
        /*BasicConfigurator.configure();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(8);
        AlgoDiffusion algoDiffusion = new DiffusionAtomique();
        //AlgoDiffusion algoDiffusion = new DiffusionSequentielle();
        Capteur capteur = new CapteurImpl(algoDiffusion);
        Afficheur   a1 = new Afficheur(1),
                    a2 = new Afficheur(2),
                    a3 = new Afficheur(3),
                    a4 = new Afficheur(4);
        Canal   c1 = new Canal(scheduledExecutorService, a1),
                c2 = new Canal(scheduledExecutorService, a2),
                c3 = new Canal(scheduledExecutorService, a3),
                c4 = new Canal(scheduledExecutorService, a4);
        capteur.attach(c1);
        capteur.attach(c2);
        capteur.attach(c3);
        capteur.attach(c4);
        capteur.unlock();*/
    }
}
