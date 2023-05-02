package Shopping;

public class Product {

    private int productId;
    private String productName;
    private String productCategory;
    private int productCount;
    private double productPrice;

    //custom constructor
    public Product(){

    }
    public Product(int productId, String productName,String productCategory, double productPrice, int productCount) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productCount = productCount;
        this.productPrice = productPrice;
    }
    public Product(int productId, String productName, double productPrice, int productCount) {
        this.productId = productId;
        this.productName = productName;
        this.productCount = productCount;
        this.productPrice = productPrice;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null) {
            return false;
        }
        Product product = (Product) obj;
        return(product.productId == this.productId && product.productName == this.productName
                && product.productCategory == this.productCategory && product.productPrice == this.productPrice
                && product.productCount == this.productCount  );

    }
    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result +this.productId;
        return result;

    }

    @Override
    public String toString() {
        return productId+" "+productName+" "+productPrice+" "+productCount;
    }



    public int getProductId() {
        return productId;
    }


    public void setProductId(int productId) {
        this.productId = productId;
    }


    public String getProductName() {
        return productName;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }


    public String getProductCategory() {
        return productCategory;
    }


    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }


    public int getProductCount() {
        return productCount;
    }


    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }


    public double getProductPrice() {
        return productPrice;
    }


    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

}