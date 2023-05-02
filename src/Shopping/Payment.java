package Shopping;

public final class Payment {

    private int paymentId;
    private String cardType;
    private String cardNo;
    Cart cart;
    public Payment(int paymentId) {

        this.paymentId = paymentId;
    }
    int cardNoInteger;
    public Payment( int paymentId, String cardType, String cardNo) throws NotValidCardNoException {

        this.paymentId = paymentId;
        this.cardType = cardType;
        this.cardNo = cardNo;

        if(cardNo.length()!=16){
            throw new NotValidCardNoException("Not a valid zip code number");
        }
        try {
            cardNoInteger = Integer.parseInt(cardNo);
        }
        catch(NumberFormatException nfe){
            System.out.println("Card number should only contain numbers");
        }


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