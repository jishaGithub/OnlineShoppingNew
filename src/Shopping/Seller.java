package Shopping;

public class Seller extends User{

    private String userName;
    private String password;
    private int sellerId;


    private Product product;
    private Payment payment;
    private Order order;


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
        return this.sellerId+" "+this.userName;
    }

    @Override
    public void getUserInfo() {
        userInfo1 = new UserInfo("Sam","sam@gmail.com");
        userInfo1.getSellerInfo();

    }

    @Override
    public void welcomeMsg() {
        System.out.println("Welcome to seller portal");

    }

    @Override
    public void login(String userName, String password) {
        if(userName.equals(this.getUserName())&&(password.equals(this.getPassword()))) {
            System.out.println(this.getUserName()+" logged in successfully");
        }
        else {
            System.out.println("Try again");
        }

    }

    public void addProducts(int productId, String productName, String productCategory, double productPrice, int productCount) {
        product = new Product(productId, productName, productCategory, productPrice, productCount);
        System.out.println(product);

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
    public UserInfo getUserInfo1() {
        return userInfo1;
    }

    public void setUserInfo1(UserInfo userInfo1) {
        this.userInfo1 = userInfo1;
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

}