package com.thanh.java8;

public class AnonymousInnerVsLambda {

    private final int x = 888;

    void hmm(){
        TheDoer d1 = new TheDoer() {

            final int x = 999;

            @Override
            public void doIt() {
                System.out.println("The Doer's x = " + this.x); // 999
            }
        };

        d1.doIt();
    }


    void lambdaHmm(){
        TheDoer d = () -> {
            System.out.println("From inside lambda, x = " + this.x);
            System.out.println("From inside lambda, toString: " + this.toString());
        };

        d.doIt();
    }

    public static void main(String[] args) {
        AnonymousInnerVsLambda match = new AnonymousInnerVsLambda();
        match.hmm();
        match.lambdaHmm();
    }

}
