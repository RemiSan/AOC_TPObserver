package com.rviottymespana;

import com.rviottymespana.models.StampedValue;

import java.util.concurrent.Future;

public interface CapteurAsync {
    Future<StampedValue> getValue();
}
