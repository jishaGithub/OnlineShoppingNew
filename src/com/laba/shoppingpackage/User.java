package com.laba.shoppingpackage;


import com.laba.exceptionpackage.NotValidZipException;
import com.laba.exceptionpackage.SameValueException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public abstract class User {
    protected static HashSet<String> userHashSet = new HashSet<>();
    protected static HashSet<Address> userAddressHashSet = new HashSet<>();
    protected static HashMap<Integer, Product> productHashMap = new HashMap<>();
    protected static HashSet<String> sellerHashSet = new HashSet<>();
    protected static TreeMap<String,String> customerLoginCredentials = new TreeMap<>();
    protected static TreeMap<String,Double> productPriceHashMap = new TreeMap<>();
    protected static TreeMap<String,Integer> productCountHashMap = new TreeMap<>();
    private static Logger logger = LogManager.getLogger(User.class);
    protected boolean isLoginSuccessful = false;
    protected String name;
    protected String emailAddress;
    protected String phoneNumber;
    protected Address address;
    protected int userId;
    protected String userName;
    protected String password;
    protected boolean isLoginCredentialsSet = false;

    public abstract void displayWelcomeMsg();

    public abstract void login(String userName, String password) throws SameValueException;
    public Address setUserAddress(String street, String city, String state, int zip) throws NotValidZipException {
        if (zip > 99999 || zip < 10000) {
            throw new NotValidZipException(zip,"Not a valid zip code :"+zip);
        }
        address = new Address(street, city, state, zip);
        return address;
    }


}
