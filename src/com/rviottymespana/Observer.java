package com.rviottymespana;

public interface Observer<T> {
    void update(T subject);
}
