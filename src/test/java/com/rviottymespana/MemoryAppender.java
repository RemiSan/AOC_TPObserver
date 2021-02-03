package com.rviottymespana;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryAppender extends ListAppender<ILoggingEvent> {

    public List<Integer> getListOfValuesDisplayedByAfficheurIndex(Integer index){
        return this.list.stream()
                .filter(iLoggingEvent -> iLoggingEvent.getFormattedMessage().startsWith("Afficheur " + index + " "))
                .sorted(Comparator.comparingLong(ILoggingEvent::getTimeStamp))
                .map(iLoggingEvent -> Integer.parseInt(iLoggingEvent.getFormattedMessage().replaceAll("Afficheur " + index + " : Valeur reçue ", "")))
                .collect(Collectors.toList());
    }

}
