
package Shopping;


import java.util.HashMap;

public class Address implements AddressInterface {

    private int addressId;
    private String streetAddress;
    private String city;
    private String state;
    private int zip;

    public Address(int addressId,String streetAddress, String city, String state, int zip) throws NotValidZipException {
        this.addressId = addressId;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;

    }
    @Override
    public String toString() {
        return this.addressId+" "+this.streetAddress+" , "+this.city+" , "+this.state+" , "+zip;
    }

    public String getAddress() {
        return this.addressId+"  "+this.streetAddress +","+ this.city +","+  this.state +","+ this.zip;
    }


    public int getAddressId() {
        return addressId;
    }


    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }


    public String getStreetAddress() {
        return streetAddress;
    }


    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }


    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }


    public String getState() {
        return state;
    }


    public void setState(String state) {
        this.state = state;
    }


    public int getZip() {
        return zip;
    }


    public void setZip(int zip) {
        this.zip = zip;
    }

    @Override
    public void setBillingAddress() {
        System.out.println("Billing Address");

    }

    @Override
    public void setShippingAddress() {
        System.out.println("Shipping Address");

    }


}