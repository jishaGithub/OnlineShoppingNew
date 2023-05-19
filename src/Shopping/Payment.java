package Shopping;

public class Payment {
    private int cartId;
    private int paymentId;
    private String cardType;
    private String cardNo;

    //custom constructor
    public Payment(int paymentId, int cartId) {
        this.setCartId(cartId);
        this.setPaymentId(paymentId);
    }

    //getter for card type
    public String getCardType() {
        return cardType;
    }

    //setter for card type
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    // getter for card no
    public String getCardNo() {
        return cardNo;
    }

    // setter for card no
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    // function to display the purchase confirmation
    public void makePurchase(){
        System.out.println("Paid using "+this.cardType+" card ending with "+this.cardNo.substring(12));
        System.out.println("Purchase Successful!");
    }

    // getter for cart id
    public int getCartId() {
        return cartId;
    }

    // setter for cart id
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    // getter for payment id
    public int getPaymentId() {
        return paymentId;
    }

    // setter for payment id
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }



}