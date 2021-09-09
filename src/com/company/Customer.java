package com.company;

import java.util.LinkedList;

public class Customer {
    private String givenName;
    private LinkedList<FoodAndDrinks> order;
    private int orderNumber;

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public LinkedList<FoodAndDrinks> getOrder() {
        return order;
    }

    public void addToOrder(FoodAndDrinks item) {
        this.order.add(item);
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
}
