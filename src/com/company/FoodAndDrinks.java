
package com.company;
import java.util.*;
import java.math.*;

public class FoodAndDrinks {
    private double price;
    private String name;
    private String typeOfMeal;
    private boolean isVegetarian;

    public FoodAndDrinks(double price, String name, String typeOfMeal, boolean isVegetarian){
        this.name = name;
        this.price = price;
        this.typeOfMeal = typeOfMeal;
        this.isVegetarian = isVegetarian;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfMeal() {
        return typeOfMeal;
    }

    public void setTypeOfMeal(String typeOfMeal) {
        this.typeOfMeal = typeOfMeal;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public static FoodAndDrinks findFoodByName(ArrayList<FoodAndDrinks> entireMenu, String name){
        for (int i = 0; i < entireMenu.size(); i++){
            if (entireMenu.get(i).name.equals(name)){
                return entireMenu.get(i);
            }
        }
        return null;
    }


}
