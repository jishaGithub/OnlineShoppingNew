package Shopping;
public class Shipping {
    private int shippingId;
    private int userId;
    private String shippingAddress;
    private String shippingCompany;

    //custom constructor
    public Shipping(int shippingId, int userId) {
        this.setShippingId(shippingId);
        this.setUserId(userId);
    }

    // function for displaying the shipping confirmation
    public String shippingInfo() {
        return "Shipping ID: "+shippingId+" Address:  "+shippingAddress
                +". \nShipping via "+this.getShippingCompany();
    }

    // getter for shipping id
    public int getShippingId() {
        return shippingId;
    }

    // setter for shipping id
    public void setShippingId(int shippingId) {
        this.shippingId = shippingId;
    }

    // getter for user id
    public int getUserId() {
        return userId;
    }

    // setter for user id
    public void setUserId(int userId) {
        this.userId = userId;
    }

    // getter for shipping address
    public String getShippingAddress() {
        return shippingAddress;
    }

    // setter for shipping address
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    // getter for shipping company info
    public String getShippingCompany() {
        return shippingCompany;
    }

    // setter for shipping company info
    public void setShippingCompany(String shippingCompany) {
        this.shippingCompany = shippingCompany;
    }



}