package com.rviottymespana;

public interface Capteur extends Subject{
    Integer getValue();
    void tick();
    void lock();
}
