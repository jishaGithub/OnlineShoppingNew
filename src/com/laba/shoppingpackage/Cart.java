package com.laba.shoppingpackage;

import com.laba.exceptionpackage.NotPositiveException;
import com.laba.linkedpackage.linkedList;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;



public class Cart {
    private static final Logger logger = LogManager.getLogger(Cart.class);
    private static ArrayList<String> cartList = new ArrayList();
    private static linkedList<String> cartLinkedList = new linkedList();
    private static ArrayList<Double> tempTotal = new ArrayList<>();
    private static double totalCost =0;
    private double totalPrice=0;
    private int cartId;
    public static double currentTotal;
    private ArrayList<Product> productsListInCart= new ArrayList();
    private String cart ="\nWelcome to my cart \n\n";
    private Product product;


    public Cart(int cartId) {
        this.cartId = cartId;
        logger.log(Level.INFO,"Cart object created");
    }

    public void addProductsToCart(int productId, String productName, double productPrice,int productCount) throws NotPositiveException {
        logger.log(Level.INFO,"Product added to cart");
        this.currentTotal = productPrice*productCount;
        product = new Product(productId,productName,productPrice,productCount);
        productsListInCart.add(product);
        cartList.add("Cart ID: "+cartId+" Product: "+productName+" Price: "+productPrice+" Count: "+productCount+" Total: "+this.currentTotal);
        tempTotal.add(this.currentTotal);
        try(FileOutputStream fos = new FileOutputStream("ShoppingCart.txt")){
            for(int i=0;i<cartList.size();i++){
                String[] arr = new String[cartList.size()];
                arr[i]=cartList.get(i);
                fos.write(arr[i].getBytes());
            }
        }
        catch(Exception e1){
            System.out.println(e1);
        }
    }

    public double getTotalPrice() {
        for(int i=0;i<tempTotal.size();i++){
            this.totalPrice+=tempTotal.get(i);
        }
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(totalPrice));
    }



    public double viewCart() {
        logger.log(Level.INFO,"Viewing Cart");
        for(int i=0;i<cartList.size();i++){
            System.out.println(cartList.get(i));
        }
        System.out.println("------------------------------------------");
        System.out.println("Total price -  "+this.getTotalPrice());
        return this.getTotalPrice();
    }

}
