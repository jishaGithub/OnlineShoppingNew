package Shipping;

public class Shipping implements ShippingInterface{


    private int shippingId;
    private String shippingAddress;
    private String shippingCompany;
    private ShippingPreference shippingPref;
    private static double shippingCost;


    static {
        shippingCost = 0;
    }

    public Shipping( int shippingId) {

        this.shippingId = shippingId;
    }

    public final double calculateShippingCost(ShippingPreference shippingPref, double totalPrice) {

        if(shippingPref.equals(shippingPref)) {
            shippingCost = 50;
            return this.domestic(totalPrice);
        }
        else {
            shippingCost = 100;;
            return this.international(totalPrice);
        }
    }



    public static double getShippingcost() {
        return shippingCost;
    }

    // function for displaying the shipping confirmation
    public String shippingInfo() {
        return "Shipping ID: "+shippingId+" Address:  "+shippingAddress
                +". \nShipping via "+this.getShippingCompany();
    }

    @Override
    public double domestic(double totalPrice) {return totalPrice + Shipping.getShippingcost(); }

    @Override
    public double international(double totalPrice) {
        return totalPrice * Shipping.getShippingcost();
    }


    public int getShippingId() {
        return shippingId;
    }

    public void setShippingId(int shippingId) {
        this.shippingId = shippingId;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getShippingCompany() {
        return shippingCompany;
    }

    public void setShippingCompany(String shippingCompany) {
        this.shippingCompany = shippingCompany;
    }

    public ShippingPreference getShippingPref() {
        return shippingPref;
    }

    public void setShippingPref(ShippingPreference shippingPref) {
        this.shippingPref = shippingPref;
    }







}