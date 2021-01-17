package com.rviottymespana;

import java.util.concurrent.ExecutionException;

public class Afficheur implements ObserverDeCapteur {



    @Override
    public void update(CapteurAsync subject) {

        try {
            System.out.println(subject.getValue().get()); //TODO : change to a Logger
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
