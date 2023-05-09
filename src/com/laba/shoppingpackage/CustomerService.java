package com.laba.shoppingpackage;

import com.laba.discountpackage.Discount;
import com.laba.exceptionpackage.NotPositiveException;
import com.laba.exceptionpackage.NotValidCardNoException;
import com.laba.shippingpackage.Shipping;
import com.laba.shippingpackage.ShippingPreference;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DecimalFormat;

public class CustomerService extends Customer {
    private static final Logger logger = LogManager.getLogger(CustomerService.class);
    private Cart cart;
    private Shipping shipping;
    private static double totalCost;
    private boolean isOrderPlaced = false;
    private boolean ifPurchaseCompleted = false;
    private boolean isShippingInfoSet = false;
    private double priceWithDiscount;
    private Discount discount;
    private Payment payment;
    DecimalFormat df = new DecimalFormat("#.##");
    public CustomerService(int customerId) {
        super(customerId);
    }
    public void addProductsToCart(int productId, String productName, double productPrice, int productCount) throws NotPositiveException {
        if ((productCount < 0) || (productPrice < 0)) {
            String errorCount = productCount+" , "+productPrice;
            throw new NotPositiveException(errorCount,"Product count/Product Price cannot be negative "+errorCount);
        }
        cart = new Cart(1);
        cart.addProductsToCart(productId, productName, productPrice, productCount);
    }
    public void showCart() {
        System.out.println("\n******* Cart of customer ID: " + this.getCustomerId() + " *********");
        totalCost = cart.viewCart();
        totalCost = totalCost/2;
    }

    public void placeOrder(){
        Order order = new Order(1);
        System.out.println(order);
        isOrderPlaced = true;
        displayOrderDetails();
    }
    public void displayOrderDetails(){
        if(isShippingInfoSet) {
            System.out.println("The total cost before shipping and discount : " + totalCost);
            double priceWithShipping = shipping.calculateShippingCost(ShippingPreference.Domestic, totalCost);
            System.out.println("The total cost including shipping cost : " + priceWithShipping);
            discount = new Discount(1, true);
            priceWithDiscount = discount.discountTotalPrice(priceWithShipping, true);
            System.out.println("The total cost after applying discount : " + df.format(priceWithDiscount));
        }
        else{
            System.out.println("Shipping info is not set. Please add shipping details");
        }
    }

    public void makePurchase(int paymentId, String cardType, String cardNo) throws NotValidCardNoException {
        if(isOrderPlaced) {
            if (cardNo.length() != 16) {
                throw new NotValidCardNoException("Card number should be 16 digits");
            }
            try {
                int intCardNo = Integer.parseInt(cardNo);
            } catch (NumberFormatException nfe) {
                logger.log(Level.INFO, "Card number format error");
            }
            payment = new Payment(cardType, cardNo);
            payment.makePurchase(Double.parseDouble(df.format(priceWithDiscount)));
            ifPurchaseCompleted = true;
        }
    }

    public void setShippingInfo(int id,String shippingCompany){
        shipping = new Shipping(1,"Fedex");
        isShippingInfoSet = true;
    }

    public void displayShippingInfo(){
        if(ifPurchaseCompleted){
            shipping.displayShippingConfirmation();
        }
    }
}
