package com.rviottymespana;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Afficheur implements ObserverDeCapteur {

    final Logger logger = LoggerFactory.getLogger(Afficheur.class);

    @Override
    public void update(CapteurAsync subject) {
        try {
            logger.info("Valeur reçue {}", subject.getValue().get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
