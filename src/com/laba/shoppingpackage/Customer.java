package com.laba.shoppingpackage;


import com.laba.exceptionpackage.NotValidZipException;
import com.laba.exceptionpackage.PhoneNumberLengthException;
import com.laba.exceptionpackage.SameValueException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Customer extends User {
    private static int customerCount = 0;
    private static final Logger logger = LogManager.getLogger(Customer.class);
    protected int customerId;
    private boolean isLoginSuccess = false;
    private boolean newCustomer = false;
    private boolean isAddressAdded = false;
    private long phoneLong;

    public Customer(int customerId) {
        this.customerId = customerId;
    }

    public Customer(int customerId, String name, String emailAddress, String phoneNumber) throws PhoneNumberLengthException {
        this.userId = customerId;
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        customerCount++;
        logger.log(Level.INFO,"Customer object created");
        if(!(Long.valueOf(phoneNumber) instanceof Long)){
            throw new NumberFormatException();
        }
        if(phoneNumber.length()>10 || phoneNumber.length()<10){
            throw new PhoneNumberLengthException(phoneNumber,"Phone number length error: "+phoneNumber);
        }

        }

    public static void displayCustomerCount(){
        System.out.println("The total count of customers : "+customerCount);
    }
    public void setLoginCredentials(String userName,String password){
        if((userName.getClass() != String.class) || (password.getClass() != String.class)){
            throw new IllegalArgumentException("The arguments should be in String format");
        }
        this.userName = userName;
        this.password = password;
        customerLoginCredentials.put(userName,password);
        this.isLoginCredentialsSet = true;
    }
    public boolean isLoginSuccessful(){

        return isLoginSuccess;
    }

    public void displayWelcomeMsg() {
        if (isLoginSuccessful()){
            System.out.println("Welcome to Customer portal");
        }
        else{
            System.out.println("Access to portal denied. Login first");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Customer customer = (Customer) obj;
        return (customer.customerId == this.customerId && customer.userName == this.userName);
    }
    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + this.customerId;
        return result;
    }

    public void login(String userName, String password) throws SameValueException {
        if(isLoginCredentialsSet) {
            logger.log(Level.INFO, "Customer " + this.customerId + " login attempt");
            if (userName.equals(password)) {
                logger.log(Level.INFO, "Customer " + this.customerId + " - SameValueException");
                isLoginSuccess = false;
                throw new SameValueException(userName,"The username and password cannot be same");
            }
            if ((userName == this.getUserName()) && (password == customerLoginCredentials.get(userName))) {
                System.out.println(this.getUserName() + " logged in successfully");
                logger.log(Level.INFO, "Customer " + this.customerId + " - logged in successfully");
                isLoginSuccess = true;
            } else {
                logger.log(Level.INFO, "Customer " + this.customerId + " unsuccessful login");
                System.out.println("Try again");
                isLoginSuccess = false;
            }
        }
        else{
            System.out.println("Login credentials are not set. Login unsuccessful!");
            isLoginSuccess = false;
        }
    }

    public static void viewCustomersAddresses() {
        System.out.println("\n-----CUSTOMER ADDRESSES------");
        for (Address address1 : userAddressHashSet) {
            System.out.println(address1);
        }
    }
    public static void viewCustomers() {
        System.out.println("\n----CUSTOMER LIST-----");
        for (String customers : userHashSet) {
            System.out.println(customers);
        }
        System.out.println();
    }
    public int getCustomerId() {

        return customerId;
    }

    public String getUserName() {

        return userName;
    }


    public void setAddress(String street, String city, String state, int zip) throws NotValidZipException,NullPointerException {
        address = super.setUserAddress(street, city, state, zip);

        userHashSet.add(" ID: "+this.userId+" NAME: "+this.name+" EMAIL: "+this.emailAddress+" PHONE: "+this.phoneNumber+" ADDRESS: "+address);
        userAddressHashSet.add(address);
        isAddressAdded = true;
    }
}
