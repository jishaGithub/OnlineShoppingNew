package com.laba.shoppingpackage;



import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    private static int totalOrders=0;
    private LocalDate currentDate = LocalDate.now();
    private int orderId;
    private ArrayList<Order> orderArrayList = new ArrayList<>();

    public Order(int orderId) {
        this.setOrderId(orderId);
    }

    @Override
    public String toString() {
        return "\nMy Order\n"+this.orderId+" "+" | Order placed on: "+this.getCurrentDate()+"\n";
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public LocalDate getCurrentDate() {
        return this.currentDate;
    }
}
