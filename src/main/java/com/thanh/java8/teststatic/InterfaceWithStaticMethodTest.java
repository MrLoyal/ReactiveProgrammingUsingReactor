package com.thanh.java8.teststatic;

public class InterfaceWithStaticMethodTest{

    public static void main(String[] args) {
        MyInterFaceWithStaticMethod test = new MyImpl();

        // Static method may be invoked on containing interface class only
        // test.justPrint();


        // This is ok
        MyInterFaceWithStaticMethod.justPrint();

    }
}
