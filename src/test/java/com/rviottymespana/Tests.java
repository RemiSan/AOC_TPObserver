package com.rviottymespana;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.rviottymespana.algosdiffusion.DiffusionAtomique;
import com.rviottymespana.algosdiffusion.DiffusionEpoque;
import com.rviottymespana.algosdiffusion.DiffusionSequentielle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Tests {

    private static final String LOGGER_NAME = "com.rviottymespana";
    private static MemoryAppender memoryAppender;
    private Capteur capteur;
    private List<Afficheur> afficheurList;
    private ScheduledExecutorService scheduledExecutorService;
    private Logger logger;

    @Before
    public void setupFourAfficheurOnOneCapteur() {
        logger = (Logger) LoggerFactory.getLogger(LOGGER_NAME);
        memoryAppender = new MemoryAppender();
        memoryAppender.setContext((LoggerContext) LoggerFactory.getILoggerFactory());
        logger.setLevel(Level.INFO);
        logger.addAppender(memoryAppender);
        memoryAppender.start();
        scheduledExecutorService = Executors.newScheduledThreadPool(8);
        afficheurList = Arrays.asList(new Afficheur(1),
                                        new Afficheur(2),
                                        new Afficheur(3),
                                        new Afficheur(4));
        List<Canal> canalList = afficheurList.stream().map(afficheur -> new Canal(scheduledExecutorService, afficheur)).collect(Collectors.toList());
        capteur = new CapteurImpl();
        canalList.forEach(canal -> capteur.attach(canal));
    }

    @After
    public void shutdownExecutor() throws InterruptedException {
        scheduledExecutorService.shutdown();
        Thread.sleep(3000);
    }

    @Test
    public void testDiffusionAtomique() throws InterruptedException {
        capteur.configure(new DiffusionAtomique());
        capteur.unlock();
        Thread.sleep(10000);
        afficheurList.forEach(afficheur -> {
            List<Integer> displayedValues = memoryAppender.getListOfValuesDisplayedByAfficheurIndex(afficheur.getIndexAfficheur());
            for (int i = 0; i < displayedValues.size() - 1; i++){
                assertThat(CapteurUtils.calculateNextValue(displayedValues.get(i))).isEqualTo(displayedValues.get(i + 1));
            }
        });
    }

    @Test
    public void testDiffusionEpoque() throws InterruptedException {
        capteur.configure(new DiffusionEpoque());
        capteur.unlock();
        Thread.sleep(10000);
        afficheurList.forEach(afficheur -> {
            List<Integer> displayedValues = memoryAppender.getListOfValuesDisplayedByAfficheurIndex(afficheur.getIndexAfficheur());
            for (int i = 0; i < displayedValues.size() - 1; i++){
                assertThat(CapteurUtils.isBefore(displayedValues.get(i), displayedValues.get(i + 1))).isTrue();
            }
        });
    }

    @Test
    public void testDiffusionSequentielle() throws InterruptedException {
        capteur.configure(new DiffusionSequentielle());
        capteur.unlock();
        Thread.sleep(10000);
        List<Integer> biggestSequence = new ArrayList<>();
        afficheurList.forEach(afficheur -> {
            List<Integer> displayedValues = memoryAppender.getListOfValuesDisplayedByAfficheurIndex(afficheur.getIndexAfficheur());
            for (int i = 0; i < displayedValues.size() - 1; i++){
                assertThat(CapteurUtils.isBefore(displayedValues.get(i), displayedValues.get(i + 1))).isTrue();
            }
            if(biggestSequence.size() == 0){
                biggestSequence.addAll(displayedValues);
                return; // equals to continue in Java8 foreach
            }
            if(displayedValues.size() == 0){
                return; // equals to continue in Java8 foreach
            }
            if (biggestSequence.size() > displayedValues.size()){
                assertThat(biggestSequence).containsSubsequence(displayedValues);
            }
            else{
                assertThat(displayedValues).containsSubsequence(biggestSequence);
                biggestSequence.clear();
                biggestSequence.addAll(displayedValues);
            }
        });
    }
}
