package Shopping;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.HashSet;

public abstract class User {
    protected String name;
    protected String emailAddress;
    protected String phoneNumber;
    protected Address address;
    protected int id;
    protected String userName;
    protected String password;
    //protected static HashMap<Integer,HashSet<Address>> addressHashMap = new HashMap<>();
    protected static HashSet<Address> addressHashSet = new HashSet<>();
    public abstract void getUserInfo() throws InvalidAddressException;
    private static Logger logger = LogManager.getLogger(Shopping.User.class);

    public abstract void welcomeMsg();

   public abstract void login (String userName, String password) throws SameValueException;

    public void setUserInfo(int id,String userName,String password,String name, String emailAddress, String phoneNumber, Address address) throws InvalidAddressException {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.address = address;
        if(!(address instanceof Address)){
            throw new InvalidAddressException("Invalid address format");
        }
        try {
            long phoneLong = Long.parseLong(this.phoneNumber);
        }
        catch(NumberFormatException nfe){
            logger.log(Level.INFO, "Not a valid phone Number",nfe.getMessage());
        }
    }

    public void setUserInfo(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
    }

    public void getCustomerInfo() throws InvalidAddressException {
        if(!(address instanceof Address)){
            throw new InvalidAddressException("Not a valid address object");
        }
        System.out.println(this.name + " " + this.emailAddress + " " + this.phoneNumber + this.address);
    }

    public void getSellerInfo() {
        System.out.println(this.name + " " + this.emailAddress);
    }
    public void getGuestInfo() {
        System.out.println(this.name + " " + this.emailAddress + " " + this.phoneNumber + this.address);
    }

    public Address setAddressUser ( int id,String streetAddress, String city, String state,int zip) throws NotValidZipException {
            if (zip > 99999 || zip < 10000) {
                throw new NotValidZipException("Not a valid zip code");
            }
            address = new Address(id,streetAddress, city, state, zip);
            return address;

        }
    }





