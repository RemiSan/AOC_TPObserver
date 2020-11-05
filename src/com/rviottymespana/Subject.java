package com.rviottymespana;

public interface Subject {
    void attach(Observer o);
    void detach(Observer o);
}
