package com.company;

import java.util.ArrayList;

public class Order {
    private ArrayList<FoodAndDrinks> listOfFoods;
    private double orderTotal;

    public Order(ArrayList<FoodAndDrinks> listOfFoods, double orderTotal){
        this.listOfFoods = listOfFoods;
        this.orderTotal = orderTotal;
    }
    public Order(){
        this.listOfFoods = null;
        this.orderTotal = 0;
    }

    public ArrayList<FoodAndDrinks> getListOfFoods() {
        return listOfFoods;
    }

    public void setListOfFoods(ArrayList<FoodAndDrinks> listOfFoods) {
        this.listOfFoods = listOfFoods;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }
}
