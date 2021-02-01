package com.rviottymespana;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Afficheur implements ObserverDeCapteur {

    private static final Logger logger = LoggerFactory.getLogger(Afficheur.class);

    private final Integer indexAfficheur;

    public Afficheur(Integer indexAfficheur) {
        this.indexAfficheur = indexAfficheur;
    }

    @Override
    public void update(CapteurAsync subject) {
        try {
            logger.info("Afficheur {} : Valeur reçue {}", indexAfficheur, subject.getValue().get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }


    public Integer getIndexAfficheur() {
        return indexAfficheur;
    }
}
