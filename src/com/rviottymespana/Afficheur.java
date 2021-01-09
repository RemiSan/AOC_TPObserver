package com.rviottymespana;

public class Afficheur implements ObserverDeCapteur {
    @Override
    public void update(CapteurAsync subject) {
        System.out.println(subject.getValue()); //TODO : change
    }
}
