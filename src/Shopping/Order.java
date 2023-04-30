package Shopping;



import java.time.LocalDate;

public class Order {


    private int orderId;
    private static LocalDate currentDate = LocalDate.now();

    public Order(int orderId) {


        this.setOrderId(orderId);
    }

    @Override
    public String toString() {
        return "\nMy Order\n"+this.orderId+" "+" | Order placed on: "+currentDate+"\n";
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public static LocalDate getCurrentDate() {
        return currentDate;
    }
    public static void setCurrentDate(LocalDate currentDate) {
        Order.currentDate = currentDate;
    }

}