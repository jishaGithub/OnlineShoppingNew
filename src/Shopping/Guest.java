package Shopping;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class Guest extends User{
    private static final Logger logger = LogManager.getLogger(Shopping.Guest.class);
    private int guestId;
    private static HashSet<String> guestHashSet = new HashSet<>();
    private static HashSet<Address> guestAddressHashSet = new HashSet<>();

    public Guest(int guestId) {
        this.guestId = guestId;
     }

      @Override
    public void getUserInfo() {
        super.getGuestInfo();
    }

    @Override
    public void welcomeMsg() {
        System.out.println("Welcome to guest portal");
    }

    @Override
    public void login(String userName, String password) throws SameValueException {
        if(userName==password){
            throw new SameValueException("The username and password cannot be same");
        }
        if((userName==this.getUserName())&&(password==this.getPassword())) {
            System.out.println(this.getUserName()+" logged in successfully");
        }
        else {
            System.out.println("Try again");
        }

    }


        public void setAddress (int addressId,String streetAddress, String city, String state,int zip) {
            try {
                super.setAddressUser(addressId, streetAddress, city, state, zip);
            } catch (NotValidZipException nvze) {
                logger.log(Level.INFO, nvze.getMessage());
            } catch (ArrayStoreException ase) {
                logger.log(Level.INFO, ase.getMessage());
            }
            guestAddressHashSet.add(address);
        }


    public void createGuest(String userName,String password,String name, String emailAddress, String phoneNumber) throws InvalidAddressException {
        try {
            super.setUserInfo(this.guestId, userName, password, name, emailAddress, phoneNumber, address);
        }
        catch(InvalidAddressException iae){
            System.out.println(iae.getMessage());
        }
        guestHashSet.add(guestId+" "+userName+" "+password+" "+name+" "+emailAddress+" "+phoneNumber+" Address: "+address);
    }

    public static void viewAddresses(){
        System.out.println("\n------ADDRESS LIST------");
        for(Address address1 : guestAddressHashSet){
            System.out.println(address1);
        }
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public static void viewGuests() {
        System.out.println("\n----GUEST LIST-----");
        for(String guests : guestHashSet){
            System.out.println(guests);
        }
        System.out.println();
    }


}