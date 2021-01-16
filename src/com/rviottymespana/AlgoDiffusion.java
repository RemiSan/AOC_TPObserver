package com.rviottymespana;

public interface AlgoDiffusion{
    void configure(CapteurImpl capteur);
    void execute();
    void valueRead(CapteurImpl capteur);
}
