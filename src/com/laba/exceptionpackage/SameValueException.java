package com.laba.exceptionpackage;

public class SameValueException extends Exception{
    private final String sameValue;

    public SameValueException(String sameValue, String str){
        super(str);
        this.sameValue  = sameValue;
    }
}