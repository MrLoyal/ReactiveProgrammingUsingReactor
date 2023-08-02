package com.thanh.java8;

public class LeftAndRight implements Left, Right{

    // If this class does not implement its own 'go' method
    // this error will be thrown:

    // com.thanh.lambda.LeftAndRight inherits unrelated defaults for go()
    // from types com.thanh.lambda.Left and com.thanh.lambda.Right
    @Override
    public void go() {
        Left.super.go();
    }
}
