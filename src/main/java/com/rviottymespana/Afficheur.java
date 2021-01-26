package com.rviottymespana;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Afficheur implements ObserverDeCapteur {

    final Logger logger = LoggerFactory.getLogger(Afficheur.class);

    @Override
    public void update(CapteurAsync subject) {
       subject.getValue(this);
    }

    public void getUpdated(Integer updatedValue){
        logger.info("Valeur reçue {}", updatedValue);
    }
}
