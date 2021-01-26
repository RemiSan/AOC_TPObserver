package com.rviottymespana;

import java.util.concurrent.Future;

public interface CapteurAsync {
    Future<?> getValue(Afficheur afficheur);
}
