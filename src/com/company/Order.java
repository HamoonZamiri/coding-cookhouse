package com.company;

import java.util.ArrayList;

public class Order {
    private ArrayList<FoodAndDrinks> orders;
    private double orderTotal;

    public ArrayList<FoodAndDrinks> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<FoodAndDrinks> orders) {
        this.orders = orders;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }
}
