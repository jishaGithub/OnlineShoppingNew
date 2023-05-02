package Shopping;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger2 = LogManager.getLogger(Shopping.Customer.class); // Since static only one copy of logger will be created in the memory
    private static final Logger logger = LogManager.getLogger(Shopping.Main.class);
    public static void main(String[] args) throws NotPositiveException, NotValidZipException, NotValidCardNoException {

        Guest guest1 = new Guest(1,"guest1","123");
        try {
            guest1.setAddress(1, "olive road", "keene", "MI", 56789);
        }
        catch(NotValidZipException nvze){
            nvze.getMessage();
        }

        guest1.registerUser("guest1","guest1@gmail.com","fivefour");
        guest1.welcomeMsg();
        guest1.getUserInfo();


        Seller seller1 = new Seller(1, "seller123", "seller");
        try {
            seller1.login("seller123", "seller");
        }
        catch(SameValueException sve){
            System.out.println(sve.getMessage());
        }
        seller1.welcomeMsg();
        seller1.setSellerInfo("Sunny","sunny@gmail.com");
        seller1.getUserInfo();
        seller1.addProducts(1, "Apples","Fruits", 2.99, 5);


        Customer customer1 = new Customer(1, "customer123", "123");
        try {
            customer1.login("customer123", "123");
        }
        catch(SameValueException sve){
            System.out.println(sve.getMessage());
        }
        customer1.welcomeMsg();
        try {
            customer1.setAddress(1, "westland lane", "westland", "NH", 12345);
            customer1.setAddress(1, "westland lane", "westland", "NH", 123455);
        }
        catch(NotValidZipException nvze){
            nvze.getMessage();
        }

        customer1.setCustomerInfo("Jisha","jisha@gmail.com","7687868967");
        //customer1.setCustomerInfo("Jisha","jisha@gmail.com","six");
        try {
            customer1.getUserInfo();
        }
        catch(InvalidAddressException iae){
            System.out.println(iae.getMessage());
        }
        try {
            //customer1.addProductsToCart(1, "Apples", 2.99, -4);
            customer1.addProductsToCart(2, "Oranges",1.99, 5);
        }
        catch(NotPositiveException npe){
             System.out.println(npe.getMessage());
        }
        customer1.viewCart();
        customer1.placeOrder();
        try {
            customer1.makePurchase(1, 1, "VISA", "123412451256123o");
        }
        catch(NotValidCardNoException | NumberFormatException ex){
            System.out.println(ex.getMessage());  }




        //Logger logger1 = LogManager.getLogger(Shopping.Customer.class);

        /*Default configuration only logs to console error level ERROR and above */
        logger2.trace("This is a trace message");
        logger2.error("Error2 message");  // This will get printed on console
        logger.warn("Warning");
        logger.info("Info msg");
        logger2.fatal("Fatal msg"); // This will also get printed on console
        logger2.debug("Debug msg");


    }

}