
package Shopping;

public class Main {

    public static void main(String[] args) {

        Owner owner1 = new Owner(1,"Tom");
        owner1.addProducts(4, "Watermelon", 2.99);
        System.out.println(owner1.getProducts());
        owner1.setCompany("Walmart");
        System.out.println(owner1.getOwnerDetails());

        User user1 = new User(1,1);
        user1.setLoginCredentials("user123", "welcome123");
        System.out.println(user1.getUserInformation());

        Address address1 = new Address(10, 1);
        address1.setAddress("street2", "city2", "state2", 56789);
        System.out.println(address1.getAddress());


        Product product1 = new Product(1);
        product1.setProduct("Broccali", "Vegetables", 5);
        System.out.println(product1.getProductDetails());


        Cart cart1 = new Cart(1);
        cart1.addProductsToCart(3, "apples",2.50, 4);
        cart1.addProductsToCart(4, "oranges",2.0, 3);
        cart1.addProductsToCart(2, "peaches",1.0, 2);
        cart1.viewCart();


        Payment payment1 = new Payment(1001,1);
        payment1.setCardType("Visa");
        payment1.setCardNo("1234567899043567");
        payment1.makePurchase();


        Shipping shipping1 = new Shipping(1,2);
        shipping1.setShippingAddress("lost lake lane, keene, nh, 78645");
        shipping1.setShippingCompany("Fedex");
        System.out.println(shipping1.shippingInfo());





    }

}