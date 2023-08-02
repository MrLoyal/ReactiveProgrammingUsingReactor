package com.thanh.quick_test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class QuickTest {

    private static final Logger logger = LoggerFactory.getLogger(QuickTest.class);

    public static void main(String[] args) {
        final Object o1 = new Object();

        Runnable r1 = () -> {
            logger.info("Start waiting");
            try {
                o1.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            logger.info("Done waiting");
        };


        Runnable r2 = () -> {
            try{
                TimeUnit.MILLISECONDS.sleep(3000);
            } catch (InterruptedException e){
                logger.error(e.getMessage(), e);
            }
            logger.info("Now notify");
            o1.notify();
        };

        (new Thread(r1)).start();
        (new Thread(r2)).start();

        logger.info("Main is going to notify");
        o1.notify();

    }
}
