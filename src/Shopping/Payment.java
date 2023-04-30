package Shopping;

public final class Payment extends Cart{

    private int paymentId;
    private String cardType;
    private String cardNo;
    Cart cart;
    public Payment(int cartId,int paymentId) {
        super(cartId);
        this.paymentId = paymentId;
    }
    public Payment(int cartId, int paymentId, String cardType, String cardNo) {
        super(cartId);
        this.paymentId = paymentId;
        this.cardType = cardType;
        this.cardNo = cardNo;
    }


    // function to display the purchase confirmation
    public void makePurchase(double totalPrice){
        cart = new Cart(1);

        System.out.println("Paid "+totalPrice+"$ using "+this.cardType+" card ending with "+this.cardNo.substring(12));
        System.out.println("Purchase Successful!");
    }

    public int getPaymentId() {
        return paymentId;
    }


    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }


    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }


    public String getCardNo() {
        return cardNo;
    }


    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }






}