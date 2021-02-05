package com.rviottymespana;

import java.util.concurrent.ExecutionException;

import com.rviottymespana.models.StampedValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe représentant un afficheur de l'application
 */
public class Afficheur implements ObserverDeCapteur {

    private static final Logger logger = LoggerFactory.getLogger(Afficheur.class);
    private final Integer indexAfficheur;

    /**
     * Stockage de l'estampille de la dernière valeur affichée (utile seulement dans le cadre de la gestion
     * par époque)
     */
    private long lastTimeStamp;

    public Afficheur(Integer indexAfficheur) {
        this.indexAfficheur = indexAfficheur;
        this.lastTimeStamp = 0;
    }

    @Override
    public void update(CapteurAsync subject) {
        try {
            StampedValue stampedValue = subject.getValue().get();
            // vérification utile seulement pour l'algorithme de gestion par époque
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
