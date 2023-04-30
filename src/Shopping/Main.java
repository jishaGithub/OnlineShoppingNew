package Shopping;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Seller seller1 = new Seller(01, "seller123","seller" );
        //System.out.println(seller1);
        seller1.login("seller123", "seller");
        seller1.welcomeMsg();
        seller1.getUserInfo();
        seller1.addProducts(1, "Apples","Fruits", 2.99, 5);

        Customer customer1 = new Customer(1, "customer123", "123");
        customer1.login("customer123", "123");
        customer1.welcomeMsg();
        customer1.getUserInfo();
        customer1.addProductsToCart(1,"Apples",2.99,3);
        customer1.viewCart();
        customer1.placeOrder();
        customer1.makePurchase(1,1,"VISA","1234567890123456");






    }

}