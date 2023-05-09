package com.laba.shoppingpackage;

import com.laba.exceptionpackage.NotPositiveException;

public class Product {

    private static int productsCount = 0;
    private int productId;
    private String productName;
    private String productCategory;
    private int productCount;
    private double productPrice;

    public Product(){

    }
    public Product(int productId, String productName,String productCategory, double productPrice, int productCount) throws NotPositiveException {
        String errorArgument="";
        if(productCount <0 | productPrice<0 ){
            if(productCount<0){
                errorArgument = String.valueOf(productCount);
            }
            if(productPrice<0){
                errorArgument = String.valueOf(productPrice);
            }
            if(productCount<0 && productPrice<0){
                errorArgument = String.valueOf(productPrice)+" "+String.valueOf(productCount);
            }
            throw new NotPositiveException(errorArgument,"The productPrice/productCount cannot be less than zero "+errorArgument);
        }
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productCount = productCount;
        this.productPrice = productPrice;
    }
    public Product(int productId, String productName, double productPrice, int productCount) throws NotPositiveException {
        if(productCount <0 | productPrice<0 ){
            String errorCount = productCount+" , "+productPrice;
            throw new NotPositiveException(errorCount,"The productPrice/productCount cannot be less than zero "+errorCount);
        }
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
}
