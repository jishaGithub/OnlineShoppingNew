package Shopping;

public class Owner {
    private int ownerId;
    private String ownerName;
    private String ownerCompany;
    private int productId;
    private String productName;
    private double productPrice;
    //custom constructor
    public Owner(int ownerId, String ownerName) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
    }
    //setter
    public void setCompany(String name) {
        this.ownerCompany = name;
    }
    // method for adding products
    public void addProducts(int productId, String productName, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    //getter for products
    public String getProducts() {
        return productId +" "+this.productName+" "+this.productPrice;
    }

    // getter for owner details
    public String getOwnerDetails(){
        return this.ownerId +" "+this.ownerName+" "+this.ownerCompany;
    }

}
