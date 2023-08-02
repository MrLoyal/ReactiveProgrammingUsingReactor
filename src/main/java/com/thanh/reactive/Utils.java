package com.thanh.reactive;

public class Utils {

    public static void sleep(long miliseconds){
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            // just ignore
        }
    }
}
