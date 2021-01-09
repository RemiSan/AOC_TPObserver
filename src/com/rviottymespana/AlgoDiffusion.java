package com.rviottymespana;

public interface AlgoDiffusion{
    void configure(Capteur capteur);
    void execute();
    void valueRead(Capteur capteur);
}
