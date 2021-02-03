package com.rviottymespana.algosdiffusion;

import com.rviottymespana.CapteurImpl;

public interface AlgoDiffusion{
    void configure(CapteurImpl capteur);
    void execute();
    void valueRead(CapteurImpl capteur);
}
