package com.laba.shoppingpackage;

import com.laba.exceptionpackage.NotValidCardNoException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicInteger;


public final class Payment {

    private static final Logger logger = LogManager.getLogger(Payment.class);
    private static boolean paymentConfirmation;
    private static AtomicInteger ID_CREATOR = new AtomicInteger(50);
    private int paymentId;
    private String cardType;
    private String cardNo;
    private int cardNoInteger;
    public Payment( String cardType, String cardNo) throws NotValidCardNoException,NumberFormatException {

        this.paymentId = ID_CREATOR.incrementAndGet();
        this.cardType = cardType;
        this.cardNo = cardNo;

        if(cardNo.length()!=16){
            throw new NotValidCardNoException("Credit card number length error");
        }
        try {
            cardNoInteger = Integer.parseInt(cardNo);
        }
        catch(NumberFormatException nfe){
             logger.log(Level.INFO,nfe.getMessage());
        }

    }


    public void makePurchase(double totalPrice){
        System.out.println("Paid "+totalPrice+"$ using "+this.cardType+" card ending with "+this.cardNo.substring(12));
        System.out.println("Purchase Successful!");
        paymentConfirmation=true;

    }

}