package com.rviottymespana;

import java.util.concurrent.Future;

public interface Observer<T> {
    Future<?> update(T subject);
}
