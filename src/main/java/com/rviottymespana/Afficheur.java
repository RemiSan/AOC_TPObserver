package com.rviottymespana;

import java.util.concurrent.ExecutionException;

import com.rviottymespana.models.StampedValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Afficheur implements ObserverDeCapteur {

    private static final Logger logger = LoggerFactory.getLogger(Afficheur.class);

    private final Integer indexAfficheur;

    private long lastTimeStamp;

    public Afficheur(Integer indexAfficheur) {
        this.indexAfficheur = indexAfficheur;
        this.lastTimeStamp = 0;
    }

    @Override
    public void update(CapteurAsync subject) {
        try {
            StampedValue stampedValue = subject.getValue().get();
            // vérification utile pour l'algorithme de gestion par époque
            if (stampedValue.getTimestamp() > lastTimeStamp) {
                lastTimeStamp = stampedValue.getTimestamp();
                logger.info("Afficheur {} : Valeur reçue {}", indexAfficheur, stampedValue.getValue());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }


    public Integer getIndexAfficheur() {
        return indexAfficheur;
    }
}
