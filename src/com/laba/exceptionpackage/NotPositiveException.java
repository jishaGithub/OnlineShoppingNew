package com.laba.exceptionpackage;

public class NotPositiveException extends Exception{
    private final String count;

    public NotPositiveException(String count, String str){
        
        super(str);
        this.count = count;
    }

}