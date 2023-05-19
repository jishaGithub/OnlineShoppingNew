package com.laba.exceptionpackage;
public class NotValidZipException extends Exception{
    private final int zipCode;

    public NotValidZipException( int zipCode,String str){
        super(str);
        this.zipCode = zipCode;

    }


}