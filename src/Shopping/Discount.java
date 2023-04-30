package Shopping;



public class Discount extends Cart implements DiscountInterface {

    private int discountId;
    private static Boolean newUser= true;
    private static double discountCodeNewUser;
    private final double FESTIVAL_DISCOUNT = .98;



    public Discount(int cartId, int discountId,Boolean newUser) {
        super(cartId);
        this.setDiscountId(discountId);
    }

    public final double discountTotalPrice(double totalPrice,Boolean newUser) {
        if(newUser == true) {
            discountCodeNewUser = .85;
            return this.newUser(totalPrice);
        }
        else if(totalPrice>50) {
            discountCodeNewUser = .90;
            return this.freeShipping(totalPrice);
        }
        return totalPrice;
    }



    @Override
    public double newUser(double totalPrice) {
        return totalPrice*discountCodeNewUser*this.FESTIVAL_DISCOUNT;

    }

    @Override
    public double freeShipping(double totalPrice) {
        return totalPrice*discountCodeNewUser*this.FESTIVAL_DISCOUNT;

    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }



    public int getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    public static Boolean getNewUser() {
        return newUser;
    }

    public static void setNewUser(Boolean newUser) {
        Discount.newUser = newUser;
    }

}