package com.rviottymespana;

public class CapteurUtils {

    /**
     * Permet de calculer l'incrémentation d'une valeur
     * @param currentValue Integer dont on souhaite la valeur incrémentée
     * @return Integer valeur incrémentée
     */
    public static Integer calculateNextValue(Integer currentValue) {
        return currentValue + 1;
    }

    /**
     * Permet de déterminer si une valeur était sensée être diffusée avant une autre
     * @param value1 valeur sensée être diffusée avant l'autre
     * @param value2 valeur sensée être diffusée après l'autre
     * @return si value1 était sensée être diffusée value2
     */
    public static boolean isBefore(Integer value1, Integer value2) {
        return value1 <= value2;
    }
}
