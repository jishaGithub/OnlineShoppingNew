package Shopping;



public class Product {
    private int productId;
    private String productName;
    private String productCategory;
    private int productCount;
    //custom constructor
    public Product(int productId) {
        this.productId = productId;
    }
    //setter
    public void setProduct(String productName,String productCategory, int productCount ) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.productCount = productCount;
    }

    //getter
    public String getProductDetails() {
        return productId+" "+productName+" "+productCategory+" "+productCount;
    }

    // regular method
    public void classInfo(){
        System.out.println("Method of class - product");
    }



}