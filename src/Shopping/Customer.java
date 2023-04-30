package Shopping;


public class Customer extends User {
    private int customerId;
    private String userName;
    private String password;


    private Payment payment;
    private Order order;
    private Cart cart;
    private Shipping shipping;
    private Discount discount;
    private double priceWithShipping;
    private double priceWithDiscount;


    public Customer(int customerId, String userName, String password) {
        this.customerId = customerId;
        this.userName = userName;
        this.password = password;
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


    @Override
    public void getUserInfo() {
        address = new Address(1,"westland lane","westland","NH",67894);
        userInfo1 = new UserInfo("Jisha","jisha@gmail.com","8690001234",address);
        userInfo1.getCustomerInfo();

    }
    @Override
    public void welcomeMsg() {
        System.out.println("Welcome to customer portal");

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

    public void addProductsToCart(int productId, String productName, double productPrice,int productCount ) {
        cart = new Cart(1);
        cart.addProductsToCart(productId,productName,productPrice,productCount);

    }

    public void viewCart() {
        cart.viewCart();
    }

    public void placeOrder() {
        order = new Order(1);
        System.out.println(order);

    }

    public void makePurchase(int cartId, int paymentId, String cardType, String cardNo) {

        shipping = new Shipping(1);
        System.out.println("The total cost before shipping and discount : "+cart.getTotalPrice());
        priceWithShipping = shipping.calculateShippingCost(ShippingPreference.Domestic,cart.getTotalPrice());
        System.out.println("The total cost including shipping cost : "+priceWithShipping);
        discount = new Discount(cartId,1,true);
        priceWithDiscount = (int)(discount.discountTotalPrice(priceWithShipping,true)*100)/100.0;
        System.out.println("The total cost after applying discount : "+priceWithDiscount);
        payment = new Payment(cartId,paymentId,cardType,cardNo);
        payment.makePurchase(priceWithDiscount);

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
