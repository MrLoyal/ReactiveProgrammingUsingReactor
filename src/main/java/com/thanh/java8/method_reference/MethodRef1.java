package com.thanh.java8.method_reference;

import java.lang.reflect.Constructor;

public class MethodRef1 {

    public static void main(String[] args) {
        MyFunctionalInterface itf = MyMachine::whatEver;

        itf.playWithIt();


        System.out.println("===========");

        PlayWithString playWithString = StringPlayer::haha;
        playWithString.ohYeah("you");

        System.out.println("===========");

        InstancePlayer instancePlayer = new InstancePlayer();
        Runnable r = instancePlayer::ohGosh;

        (new Thread(r)).start();

        System.out.println("[ " + Thread.currentThread().getName() + " ] - ");
        System.out.println("[ " + Thread.currentThread().getName() + " ] - "
                + "=========== Constructor reference === ");

        DomainObject1Supplier s1 = DomainObject1::new;
        System.out.println("[ " + Thread.currentThread().getName() + " ] - " + s1.getDomainObject());

    }
}
