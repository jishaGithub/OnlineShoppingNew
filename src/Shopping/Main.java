package Shopping;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    // Since static only one copy of logger will be created in the memory
    private static final Logger logger = LogManager.getLogger(Shopping.Main.class);
    public static void main(String[] args) throws NotValidZipException, InvalidAddressException, SameValueException, NotPositiveException {

        Guest guest1 = new Guest(1);
        guest1.setAddress(1,"olive road", "keene", "MI", 56789);
        guest1.createGuest("guest1","123","Mack","mack@gmail.com","7867854567");
        Guest guest2 = new Guest(2);
        guest2.setAddress(2,"haley street","atlanta","ga",34567);
        guest2.createGuest("guest2","567","Tony","tony@gmail.com","7864539078");
        Shopping.Guest.viewGuests();
        guest1.login("guest1","123");
        guest2.login("guest2","789");
        guest1.welcomeMsg();
        Guest.viewAddresses();



        System.out.println("--------");
        Seller seller1 = new Seller(1, "seller123", "seller");
        seller1.login("seller123", "seller");

        seller1.welcomeMsg();
        seller1.setSellerInfo("Sunny","sunny@gmail.com");
        Seller.viewSellers();
        seller1.addProducts(1, "Apples", "Fruits", 2.99, 4);
        seller1.addProducts(2,"Oranges","Fruits",1.99,6);
        seller1.viewProducts();




        Customer customer1 = new Customer(1);
        customer1.setAddress(1,"westland lane", "westland", "NH", 12345);
        customer1.addCustomerInfo("cust1","456","Sam","sam@gmail.com","7894532345");
        customer1.login("cust1","456");
        customer1.welcomeMsg();
        Customer.viewCustomers();
        Customer.viewAddresses();
        customer1.addProductsToCart(2, "Oranges", 1.99, 5);
        customer1.addProductsToCart(1, "Apples", 2.99, 2);
        customer1.viewCart();
        customer1.placeOrder();
        try {
            customer1.makePurchase(1, 1, "VISA", "123412451256123");
            customer1.makePurchase(1, 1, "VISA", "1234124512561237");
        }
        catch(NotValidCardNoException ex){
            logger.log(Level.INFO,ex.getMessage());
        }

      logger.warn("Warning");


    }

}