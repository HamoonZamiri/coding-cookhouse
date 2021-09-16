package com.company;

import java.util.LinkedList;
public class Customer {

    private String givenName;
    private Order order = new Order();
    private int orderNumber;

    public Customer(String givenName, Order order){
        this.givenName = givenName;
        this.order = order;
        this.orderNumber = orderNumber;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
