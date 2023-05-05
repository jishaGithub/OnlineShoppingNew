package Shopping;



import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Customer extends Shopping.User {
    private int customerId;
    private String userName;
    private String password;
    private Payment payment;
    private Order order;
    private Cart cart;
    private Shipping.Shipping shipping;
    private Discount discount;

    private double priceWithShipping;
    private double priceWithDiscount;
    private static HashSet<String> customerHashSet = new HashSet<>();
    private static HashSet<Address> customerAddressHashSet = new HashSet<>();

    private static final Logger logger = LogManager.getLogger(Shopping.Customer.class);

    public Customer(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null) {
            return false;
        }
        Customer customer = (Customer) obj;
        return(customer.customerId == this.customerId && customer.userName == this.userName );
    }


    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result +this.customerId;
        return result;
    }


    public void setAddress ( int customerId, String streetAddress, String city, String state,int zip) throws NotValidZipException {
        try {
            super.setAddressUser( customerId,streetAddress, city, state, zip);
        }
        catch(NotValidZipException nvze){
            logger.log(Level.INFO,"Not a valid zip code",nvze.getMessage());
        }
        customerAddressHashSet.add(address);
    }

    public void addCustomerInfo(String userName,String password, String name, String emailAddress, String phoneNumber) throws InvalidAddressException {
        try {
            super.setUserInfo(customerId,userName, password, name, emailAddress, phoneNumber, address);
        }
        catch(InvalidAddressException iae){
            System.out.println(iae.getMessage());
        }
        customerHashSet.add(customerId+" "+userName+" "+password+" "+name+" "+emailAddress+" "+phoneNumber+" "+address);

    }

    public static void viewAddresses(){
        System.out.println("\n-----CUSTOMER ADDRESSES------");
        for(Address address1 : customerAddressHashSet){
            System.out.println(address1);
        }
    }

    @Override
    public void getUserInfo() throws InvalidAddressException {
        getCustomerInfo();
    }

    @Override
    public void welcomeMsg() {
        System.out.println("Welcome to customer portal");
    }

    @Override
    public void login(String userName, String password) throws SameValueException {
        if(userName==password){
            throw new SameValueException("The username and password cannot be same");
        }
        if(userName.equals(this.getUserName())&&(password.equals(this.getPassword()))) {
            System.out.println(this.getUserName()+" logged in successfully");
        }
        else {
            System.out.println("Try again");
        }
    }

    public void addProductsToCart(int productId, String productName, double productPrice,int productCount ) throws NotPositiveException{

        cart = new Cart(1);
        if(productCount<0 || productId<0 || productPrice<0){
            throw new NotPositiveException("Product count/Product Price/ Product Id cannot be negative");
        }
        cart.addProductsToCart(productId,productName,productPrice,productCount);
    }

    public void viewCart() {
        System.out.println("\n******* Cart of customer ID: "+this.customerId+" *********");
        cart.viewCart();
    }

    public void placeOrder() {
        order = new Order(1,1);
        System.out.println(order.toString());

    }

    public void makePurchase(int cartId, int paymentId, String cardType, String cardNo) throws NotValidCardNoException {

        shipping = new Shipping.Shipping(1);
        System.out.println("The total cost before shipping and discount : "+cart.getTotalPrice());
        priceWithShipping = shipping.calculateShippingCost(Shipping.ShippingPreference.Domestic,cart.getTotalPrice());
        System.out.println("The total cost including shipping cost : "+priceWithShipping);
        discount = new Discount(cartId,1,true);
        priceWithDiscount = (int)(discount.discountTotalPrice(priceWithShipping,true)*100)/100.0;
        System.out.println("The total cost after applying discount : "+priceWithDiscount);
        if(cardNo.length()!=16){
            throw new NotValidCardNoException("Card number should be 16 digits");
        }
        try {
            int intCardNo = Integer.parseInt(cardNo);
        }
        catch(NumberFormatException nfe){
            logger.log(Level.INFO,"Card number format error");
        }
        payment = new Payment(paymentId,cardType,cardNo);
        payment.makePurchase(priceWithDiscount);

    }

    public static void viewCustomers() {
        System.out.println("\n----CUSTOMER LIST-----");
        for(String customers : customerHashSet){
            System.out.println(customers);
        }
        System.out.println();
    }


    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public double getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(double priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }


}