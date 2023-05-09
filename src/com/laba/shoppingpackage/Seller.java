package com.laba.shoppingpackage;

import com.laba.exceptionpackage.NotPositiveException;
import com.laba.exceptionpackage.SameValueException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Seller extends User {


    private static final Logger logger = LogManager.getLogger(Seller.class);
    private Product product;
    private Payment payment;
    private Order order;
    private static int productId = 1;


    public Seller(int userId, String name, String emailAddress) {
        this.userId = userId;
        this.name = name;
        this.emailAddress = emailAddress;
        sellerHashSet.add(this.userId+" "+this.emailAddress);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null) {
            return false;
        }
        Seller seller = (Seller) obj;
        return(seller.userId == this.userId && seller.userName == this.userName );

    }
    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result +this.userId;
        return result;
    }

    @Override
    public String toString() {
        return this.userId+" "+this.userName+" "+this.password+" "+this.emailAddress;
    }

    @Override
    public void displayWelcomeMsg() {
        if(isLoginSuccessful) {
            logger.log(Level.INFO,this.userId+" successfully called displayWelcomeMsg().");
            System.out.println("Welcome to seller portal");
        }
        else{
            logger.log(Level.INFO,"Seller ID: "+this.userId+" calling displayWelcomeMsg() before login.");
            System.out.println("You need to login first");
        }
    }

    @Override
    public void login(String userName, String password) throws SameValueException {
        if(isLoginCredentialsSet) {
            if (userName.equals(password)) {
                throw new SameValueException(userName,"The username and password cannot be same :"+userName);
            }
            if ((userName.equals(this.userName)) && (password.equals(this.password))) {
                System.out.println(this.userId + " logged in successfully");
                logger.log(Level.INFO,this.userId+" logged in successfully.");
                isLoginSuccessful = true;
            }
        }
        else {
            System.out.println("Login Credentials are not set");
        }
    }

    public void setLoginCredentials(String userName,String password){
        this.userName = userName;
        this.password = password;
        this.isLoginCredentialsSet = true;
        }


    public void addProducts(String productName, String productCategory, double productPrice, int productCount) throws NotPositiveException {
       if(isLoginSuccessful) {
           if(productPriceHashMap.containsKey(productName)){
               System.out.println("The product already added. Add a new product");
               return;
           }
           product = new Product(productId++, productName, productCategory, productPrice, productCount);
           productHashMap.put(productId, product);
           productPriceHashMap.put(productName,productPrice);
           productCountHashMap.put(productName,productCount);
           logger.log(Level.INFO, "New product object created");

       }
       else{
           System.out.println("You need to first login to add products");

       }
    }

    public static void viewProductsForSale(){
        System.out.println("******* The Products List *******");
        for (Integer i : productHashMap.keySet()) {
            System.out.println(productHashMap.get(i));
        }
    }

     public static void viewSellers() {
        System.out.println("\n----SELLER LIST-----");
        for(String sellers : sellerHashSet){
            System.out.println(sellers);
        }
        System.out.println();
    }

}