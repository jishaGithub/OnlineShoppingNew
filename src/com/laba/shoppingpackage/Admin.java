package com.laba.shoppingpackage;

import com.laba.exceptionpackage.SameValueException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Admin extends User {
    private static final Logger logger = LogManager.getLogger(Admin.class);
    private Seller seller;
    private int adminId;
    private String userName;
    private String password;

    public Admin(int adminId) {
        this.adminId = adminId;
    }

    public void setLoginCredentials(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.isLoginCredentialsSet = true;
    }

    @Override
    public void displayWelcomeMsg() {
        System.out.println("Welcome to admin portal");
    }

    @Override
    public void login(String userName, String password) throws SameValueException {
        if (isLoginCredentialsSet) {
            logger.log(Level.INFO, "Admin " + this.adminId + " login attempt");
            if (userName.equals(password)) {
                logger.log(Level.INFO, "Admin " + this.adminId + " - SameValueException");
                throw new SameValueException(userName,"The username and password cannot be same");
            }
            if ((userName.equals(this.userName)) && (password.equals(this.password))) {
                System.out.println(this.adminId + " logged in successfully");
                logger.log(Level.INFO, "Admin " + this.adminId + " - logged in successfully");
            } else {
                logger.log(Level.INFO, "Admin " + this.adminId + " unsuccessful login");
                System.out.println("Try again");
            }
        }
    }

    public void displaySellers(){
        Seller.viewSellers();
    }

    public void displayProducts(){
        Seller.viewProductsForSale();
    }

    public void displayCustomers(){
        Customer.viewCustomers();
    }
}
