package com.laba.mainpackage;

import com.laba.exceptionpackage.*;
import com.laba.shoppingpackage.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {


        System.out.println("--------");
        try {
            Seller seller = new Seller(1, "Sam", "sam@gmail.com");
            seller.setLoginCredentials("seller1", "789");
            seller.login("seller1", "789");
            seller.displayWelcomeMsg();
            seller.addProducts("Apples", "Fruits", 1.99, 5);
            seller.addProducts("Oranges", "Fruits", 1.99, 6);
            seller.addProducts("Grapes", "Fruits", 1.99, 6);
            seller.addProducts("Grapes", "Fruits", 1.99, 6);
        }
        catch(NotPositiveException | SameValueException e){
            System.out.println(e.getMessage());
        }
        System.out.println("--------");

        try {
            Customer customer = new Customer(1, "Sunny", "sunny@gmail.com", "1234564534");
            customer.setAddress("west lake street", "atlanta", "GA",45632 );
            customer.setLoginCredentials("cust1", "678");
            customer.login("cust1", "678");
            Customer customer1 = new Customer(2, "Mandy", "mandy@gmail.com", "3458942345");
            customer1.setAddress("tray lane rd","newyork","NY",34563);
            Customer.displayCustomerCount();
        }
        catch(NotValidZipException e){
            System.out.println(e.getMessage());
            logger.log(Level.INFO,"Zip code format error");
        }
        catch(SameValueException e){
            System.out.println(e.getMessage());
            logger.log(Level.INFO,e.getMessage());
        }
        catch(NumberFormatException nfe){
            System.out.println(nfe.getMessage()+" Phone number can only contain numbers");
            logger.log(Level.INFO,"Phone number error");
        }
        catch(PhoneNumberLengthException pnle){
            System.out.println(pnle.getMessage());
        }

        System.out.println("--------");
        try {
            Admin admin1 = new Admin(1);
            admin1.setLoginCredentials("admin1", "123");
            admin1.login("admin1", "123");
            admin1.displayWelcomeMsg();
            admin1.displaySellers();
            admin1.displayProducts();
            admin1.displayCustomers();
        }
        catch(SameValueException e){
            System.out.println(e.getMessage());
            logger.log(Level.INFO,e.getMessage());
        }

        try {
            CustomerService customerService1 = new CustomerService(1);
            customerService1.addProductsToCart(2, "Oranges", 1.99, 5);
            customerService1.addProductsToCart(1, "Apples", 2.99, 2);
            customerService1.addProductsToCart(5, "Grapes", 2.45, 4);
            customerService1.showCart();
            customerService1.setShippingInfo(1, "Fedex");
            customerService1.placeOrder();
            customerService1.makePurchase(1, "VISA", "1234124512561238");
            customerService1.displayShippingInfo();
        }
        catch(NotPositiveException npe){
            System.out.println(npe.getMessage());
            logger.log(Level.INFO,npe.getMessage());
        }
        catch(NotValidCardNoException nvcne){
            System.out.println(nvcne.getMessage());
            logger.log(Level.INFO,nvcne.getMessage());
        }
        catch(NumberFormatException nfe){
            System.out.println(nfe.getMessage());
            logger.log(Level.INFO,nfe.getMessage());
        }

    }
}
