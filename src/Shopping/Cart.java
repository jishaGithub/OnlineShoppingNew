package Shopping;



public class Cart {

    private int cartId;
    private int productId;
    private String productName;
    private double productPrice;
    private int count;
    private double totalPrice=0;
    private double currentTotal;
    private String cart ="\nMy Cart \n\n";

    // custom constructor
    public Cart(int cartId) {
        this.setCartId(cartId);

    }

    //  method for adding products to cart
    public void addProductsToCart(int productId, String productName, double productPrice, int count) {
        this.productId = productId;
        this.setProductName(productName);
        this.productPrice = productPrice;
        this.count = count;
        this.currentTotal = productPrice*count;
        this.totalPrice += productPrice*count;

        cart += "ID: "+this.productId+" Name:  "+getProductName()+" Price: "
                +this.productPrice+" Count: "+this.count+" Total = "+this.currentTotal+"\n";
    }


    // getter for total price of products in the cart
    public double getTotalPrice() {
        return this.totalPrice;

    }

    //method for viewing the contents of the cart
    public void viewCart() {
        System.out.println(cart);
        System.out.println("------------------------------------------");
        System.out.println("Total price -  "+getTotalPrice());
    }

    //getter for product name
    public String getProductName() {
        return productName;
    }

    //setter for product Name
    public void setProductName(String productName) {
        this.productName = productName;
    }

    // getter for cart Id
    public int getCartId() {
        return cartId;
    }

    //setter for cart Id
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }







}