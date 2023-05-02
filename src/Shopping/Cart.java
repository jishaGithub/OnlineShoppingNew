package Shopping;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class Cart  {

    protected int cartId;
    private int productId;
    private String productName;
    private double productPrice;
    private int count;
    protected double totalPrice=0;
    private Product product;
    private double currentTotal;

    ArrayList<Product> myCart = new ArrayList();
    private String cart ="\nMy Cart \n\n";

    // custom constructor
    public Cart(int cartId) {
        super();
        this.cartId = cartId;
    }


    //  method for adding products to cart
    public void addProductsToCart(int productId, String productName, double productPrice,int productCount) {
        product = new Product(productId, productName,productPrice, productCount);

        this.currentTotal = product.getProductPrice()*product.getProductCount();

        cart += "ID: "+product.getProductId()+" Name:  "+product.getProductName()+" Price: "
                +product.getProductPrice()+" Count: "+product.getProductCount()+" Total = "+this.currentTotal+"\n";
        try(FileOutputStream fos = new FileOutputStream("C:\\Users\\jisha\\IntelliJ_MyWorkPlace\\OnlineShoppingNew\\src\\Shopping.txt")){
            byte arr[] = cart.getBytes();
            fos.write(arr);
        }
        catch(Exception e1){
            System.out.println(e1);
        }
    }


    // getter for total price of products in the cart
    public double getTotalPrice() {
        this.totalPrice += this.currentTotal;
        return this.totalPrice;

    }

    //method for viewing the contents of the cart
    public void viewCart() {

        System.out.println(cart);
        System.out.println("------------------------------------------");
        System.out.println("Total price -  "+this.getTotalPrice());
    }

    //getter for product name
    public String getProductName() {
        return productName;
    }

    //setter for product Name
    public void setProductName(String productName) {
        this.productName = productName;
    }









}