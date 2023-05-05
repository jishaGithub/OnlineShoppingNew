package Shopping;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.HashSet;

public class Seller extends User{

    private String userName;
    private String password;
    private int sellerId;
    private Product product;
    private Payment payment;
    private Order order;
    private static HashSet<String> sellerHashSet = new HashSet<>();
    private static HashMap<Integer,Product> productHashMap = new HashMap<>();
    private static final Logger logger = LogManager.getLogger(Shopping.Seller.class);


    public Seller(int sellerId, String userName, String password) {
        this.setSellerId(sellerId);
        this.userName = userName;
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null) {
            return false;
        }
        Seller seller = (Seller) obj;
        return(seller.sellerId == this.sellerId && seller.userName == this.userName );

    }
    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result +this.sellerId;
        return result;
    }

    @Override
    public String toString() {
        return this.sellerId+" "+this.userName+" "+this.password+" "+this.emailAddress;
    }

    @Override
    public void getUserInfo() {
        super.getSellerInfo();
    }

    @Override
    public void welcomeMsg() {
        System.out.println("Welcome to seller portal");

    }


    @Override
    public void login(String userName, String password) throws SameValueException {
        if(userName==password){
            throw new SameValueException("The username and password cannot be same");
        }
        if((userName==this.getUserName())&&(password==this.getPassword())) {
            System.out.println(this.getUserName()+" logged in successfully");
        }
        else {
            System.out.println("Try again");
        }

    }

    public void addProducts(int productId, String productName, String productCategory, double productPrice, int productCount) throws NotPositiveException {
        try {
            product = new Product(productId, productName, productCategory, productPrice, productCount);

        }
        catch(NotPositiveException npe){
            logger.log(Level.INFO,npe.getMessage());

        }
        productHashMap.put(productId,product);
    }



    public void viewProducts(){
        for(Integer i : productHashMap.keySet()){
            System.out.println(productHashMap.get(i));
        }
    }




    public void setSellerInfo(String name, String emailAddress){
        super.setUserInfo(name,emailAddress);
        sellerHashSet.add(this.name+" "+this.emailAddress);
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

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static void viewSellers() {
        System.out.println("\n----SELLER LIST-----");
        for(String sellers : sellerHashSet){
            System.out.println(sellers);
        }
        System.out.println();
    }
}