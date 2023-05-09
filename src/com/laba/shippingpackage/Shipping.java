package com.laba.shippingpackage;

import com.laba.shoppingpackage.Payment;

public class Shipping implements ShippingInterface{


    private static double shippingCost;
    private int shippingId;
    private String shippingCompany;
    private ShippingPreference shippingPref;


    static {
        shippingCost = 0;
    }

    public Shipping( int shippingId,String shippingCompany) {

        this.shippingId = shippingId;
        this.shippingCompany = shippingCompany;
    }

    public static double getShippingCost() {
        return shippingCost;
    }
    public final double calculateShippingCost(ShippingPreference shippingPref, double totalPrice) {

        if(shippingPref.equals(shippingPref)) {
            shippingCost = 50;
            return this.domestic(totalPrice);
        }
        else {
            shippingCost = 100;;
            return this.international(totalPrice);
        }
    }

    @Override
    public double domestic(double totalPrice) {
        return totalPrice + Shipping.getShippingCost(); }

    @Override
    public double international(double totalPrice) {

        return totalPrice * Shipping.getShippingCost();
    }

   public void displayShippingConfirmation() {
        System.out.println("The shipment ID: "+this.getShippingId()
                +" is shipping via "+this.getShippingCompany());
    }

    public String getShippingCompany() {
        return shippingCompany;
    }

    public int getShippingId() {
        return shippingId;
    }


}