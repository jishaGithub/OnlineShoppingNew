package Shopping;

public abstract class User {
    protected String name;
    protected String emailAddress;
    protected String phoneNumber;
    protected Address address;

    public abstract void getUserInfo() throws InvalidAddressException;

    public abstract void welcomeMsg();

    public abstract void login(String userName, String password) throws SameValueException;

    public void setUserInfo(String name, String emailAddress, String phoneNumber, Address address) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.address = address;

        try {
            int phoneNoInt = Integer.parseInt(this.phoneNumber);
        } catch (NumberFormatException nfe) {
            System.out.println("Incorrect Phone Number Format");
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

    public void setAddressUser ( int addressId, String streetAddress, String city, String state,int zip) throws NotValidZipException {
        if (zip > 99999 || zip < 10000) {
            throw new NotValidZipException("Not a valid zip code");
        }
        address = new Address(addressId, streetAddress, city, state, zip);
    }


}



