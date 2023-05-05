package Shopping;

import Linked.linkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileOutputStream;
import java.util.ArrayList;



public class Cart extends Product {

    private static final Logger logger = LogManager.getLogger(Shopping.Cart.class);
   private static ArrayList<String> cartList = new ArrayList();
   private static linkedList<String> cartLinkedList = new linkedList();

    protected int cartId;
    private int productId;
    private String productName;
    private double productPrice;
    private int count;
    protected static double totalPrice=0;
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
    public void addProductsToCart(int productId, String productName, double productPrice,int productCount) throws NotPositiveException {
        this.currentTotal = productPrice*productCount;
        cartLinkedList.add("Cart ID: "+cartId+" Product: "+productName+" Price: "+productPrice+" Count: "+productCount+" Total: "+this.currentTotal);
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
        totalPrice += this.currentTotal;
        return totalPrice;

    }

    //method for viewing the contents of the cart
    public void viewCart() {
        cartLinkedList.display();
        /*
        for(int i=0;i<cartList.size();i++){
            System.out.println(cartList.get(i));
        }  */
        System.out.println("------------------------------------------");
        totalPrice += this.currentTotal;
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