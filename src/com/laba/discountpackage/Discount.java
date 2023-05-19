package com.laba.discountpackage;


public class Discount implements DiscountInterface {

    private static Boolean newUser= true;
    private int discountId;
    private double discountCode;

    public Discount(int discountId,Boolean newUser) {
        this.discountId = discountId;
        this.newUser = newUser;
    }

    public final double discountTotalPrice(double totalPrice,Boolean newUser) {
        if(newUser == true) {
            discountCode = .85;
            return this.newUser(totalPrice);
        }
        else if(totalPrice>50) {
            discountCode = .90;
            return this.freeShipping(totalPrice);
        }
        return totalPrice;
    }

    @Override
    public double newUser(double totalPrice) {

        return totalPrice*discountCode;
    }

    @Override
    public double freeShipping(double totalPrice) {

        return totalPrice*discountCode;
    }

}
