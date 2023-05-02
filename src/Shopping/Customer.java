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
    private Product product;
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


        public void setAddress ( int addressId, String streetAddress, String city, String state,int zip) throws NotValidZipException  {

        super.setAddressUser(addressId, streetAddress, city, state, zip);
    }


    public void setCustomerInfo(String name, String emailAddress, String phoneNumber)  {

        super.setUserInfo(name,emailAddress,phoneNumber,address);
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
             cart.addProductsToCart(productId,productName,productPrice,productCount);
             if(productCount<0 || productId<0 || productPrice<0){
                 throw new NotPositiveException("Product count/Product Price/ Product Id cannot be negative");
             }

    }

    public void viewCart() {
        cart.viewCart();
    }

    public void placeOrder() {
        order = new Order(1);
        System.out.println(order);

    }

    public void makePurchase(int cartId, int paymentId, String cardType, String cardNo) throws NotValidCardNoException {

        shipping = new Shipping(1);
        System.out.println("The total cost before shipping and discount : "+cart.getTotalPrice());
        priceWithShipping = shipping.calculateShippingCost(ShippingPreference.Domestic,cart.getTotalPrice());
        System.out.println("The total cost including shipping cost : "+priceWithShipping);
        discount = new Discount(cartId,1,true);
        priceWithDiscount = (int)(discount.discountTotalPrice(priceWithShipping,true)*100)/100.0;
        System.out.println("The total cost after applying discount : "+priceWithDiscount);
        if(cardNo.length()!=16){
            throw new NotValidCardNoException("Card number should be 16 digits");
        }
        payment = new Payment(paymentId,cardType,cardNo);
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
