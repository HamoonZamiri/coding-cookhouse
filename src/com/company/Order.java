package com.company;

import java.util.ArrayList;

public class Order {
    private ArrayList<FoodAndDrinks> listOfFoods;
    private double orderTotal;

    public Order(ArrayList<FoodAndDrinks> listOfFoods, double orderTotal){
        this.listOfFoods = listOfFoods;
    }
    public Order(){
        this.listOfFoods = null;
        this.orderTotal = 0;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public ArrayList<FoodAndDrinks> getListOfFoods() {
        return listOfFoods;
    }

    public void setListOfFoods(ArrayList<FoodAndDrinks> listOfFoods) {
        this.listOfFoods = listOfFoods;
    }

    public double getTotal(){
        double total = 0;
        for (int i = 0; i < listOfFoods.size(); i++){
            total += listOfFoods.get(i).getPrice();
        }
        return total;
    }
    public void addItemToMenu(ArrayList<FoodAndDrinks>currentMenu, FoodAndDrinks newFood){
        currentMenu.add(newFood);
    }
}
