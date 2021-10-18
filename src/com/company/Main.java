package com.company;
import java.io.FileWriter;
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    static ArrayList<FoodAndDrinks> currentMenu = initializeMenu();

    public static void main(String[] args) {
	// write your code here
    int userAdminChoice = 0;

    System.out.println("1: Manager use | 2: Take an order | -1: Exit");
    Scanner sc = new Scanner(System.in);
    userAdminChoice = sc.nextInt();

    while (userAdminChoice != -1){
        if (userAdminChoice == 1) {
            printAdminMenu();
        }
        else if(userAdminChoice == 2){
            customerChoices();
        }
        else {
            System.out.println("Invalid Selection!");
            System.out.println("1: Manager use\n2: Take an order\n-1: Exit");
        }
    }
    overwriteMenuToFile();
    System.out.println("Cooking CodeHouse Software Terminated!");
    }
    public static ArrayList<FoodAndDrinks> initializeMenu() {
        File myFile = new File("menu.txt");
        if (myFile.exists()) {
            Scanner fileReader = new Scanner(myFile);
            String[] currentMenuItem;
            ArrayList<FoodAndDrinks> returnMe = null;

            int counter = 0;
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                currentMenuItem = data.split(",");
                FoodAndDrinks tempFood = new FoodAndDrinks(Double.parseDouble(currentMenuItem[0]), currentMenuItem[1],
                        currentMenuItem[2], Boolean.parseBoolean(currentMenuItem[3]));

                returnMe.add(counter, tempFood);
                counter++;

            }
            fileReader.close();
            return returnMe;
        }
        else{
            System.out.print("File does not exist");
        }

    }
    public static void overwriteMenuToFile(){
        try{
            FileWriter myWriter = new FileWriter("menu.txt", false);
            for(int i = 0; i < currentMenu.size(); i++){
                myWriter.write(Double.toString(currentMenu.get(i).getPrice()) + ",");
                myWriter.write(currentMenu.get(i).getName() + ",");
                myWriter.write(currentMenu.get(i).getTypeOfMeal() + ",");
                myWriter.write(Boolean.toString(currentMenu.get().isVegetarian()));
            }
            myWriter.close();
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void adminChoices(){
        int choice = 0;
        final int ADD_ITEM = 1;
        final int REMOVE_ITEM = 2;
        final int CHANGE_PRICE = 3;
        final int DISPLAY_MENU = 4;
        final int EXIT = 5;

        Scanner scNums = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        Scanner scBool = new Scanner(System.in);
        while (choice != EXIT){
            System.out.println("1: Add item to our menu");
            System.out.println("2: Remove item from our menu");
            System.out.println("3: Change price of an existing item");
            System.out.println("4: Display menu");
            System.out.println("5: Exit");
            choice = scNums.nextInt();
            if (choice == ADD_ITEM){
                System.out.println("Enter the name of the menu item: ");
                String newItem = scStr.nextLine().toLowerCase();

                System.out.println("Enter the type of the new item: ");
                String typeOfItem = scStr.nextLine();

                System.out.println("Enter the price of the new item: ");
                double priceOfNewItem = scNums.nextDouble();

                boolean isVeg = false;
                int vegChoice = 0;

                while (vegChoice != 1 && vegChoice != 2) {
                    System.out.println("1: is vegetarian\n2: not vegetarian ");
                    vegChoice = scNums.nextInt();
                }
                if(vegChoice == 1){
                    isVeg = true;
                }
                FoodAndDrinks newFood = new FoodAndDrinks(priceOfNewItem, newItem, typeOfItem, isVeg);
            }
            else if (choice == REMOVE_ITEM){
                System.out.println("Enter the name of the menu item: ");
                String item = scStr.nextLine().toLowerCase();
                FoodAndDrinks itemBeingRemoved = FoodAndDrinks.findFoodByName(currentMenu, item);
                if(itemBeingRemoved != null) {
                    currentMenu.remove(itemBeingRemoved);
                }
                else{
                    System.out.println("Item was not found in the current menu");
                }
            }
            else if (choice == CHANGE_PRICE){
                System.out.println("Enter the name of the menu item: ");
                String item = scStr.nextLine().toLowerCase();

                System.out.println("Enter the new price: ");
                double newPrice = scNums.nextDouble();

                FoodAndDrinks foodToBeModified = FoodAndDrinks.findFoodByName(currentMenu, item);
                if(foodToBeModified == null) System.out.println("Food was not found");
                else foodToBeModified.setPrice(newPrice);
            }
            else if (choice == DISPLAY_MENU){
                printFoodAndDrinkOptions();
            }
        }


    }
    public static void customerChoices (){
        int choice = 0;
        final int ADD_ITEM = 1;
        final int REMOVE_ITEM = 2;
        final int CHECK_TOTAL = 3;
        final int DISPLAY_MENU = 4;
        final int PAY = 5;
        final int EXIT = 6;

        Scanner scNums = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        System.out.println("Customers name: ");
        String custName = scStr.nextLine();

        ArrayList<FoodAndDrinks> orderList = null; //Order for the current customer
        Order customersOrder = new Order(orderList, 0);

        Customer currentCust = new Customer(custName, customersOrder); //initialize instance of the current customer

        choice = scNums.nextInt();
        while (choice != EXIT){
            //displaying menu options for customer
            System.out.println("1: Add item to order");
            System.out.println("2: Remove item from order");
            System.out.println("3: Check Total");
            System.out.println("4: Pay for Order");
            System.out.println("5: Display Current Food and Drink Options");
            System.out.println("6: Cancel Order and Exit");
            choice = scNums.nextInt();
            if (choice == ADD_ITEM){ //adding an item to a customers order
                System.out.println("Enter the name of the menu item: ");
                String menuItemChosen = scStr.nextLine().toLowerCase();
                FoodAndDrinks foodChosen = FoodAndDrinks.findFoodByName(currentMenu, menuItemChosen);
                if(foodChosen != null){
                    //add item to customers personal order arraylist
                    currentCust.getOrder().addItemToMenu(currentCust.getOrder().getListOfFoods(), foodChosen);
                    //change customers total checkout cost
                    currentCust.getOrder().setOrderTotal(currentCust.getOrder().getOrderTotal() + foodChosen.getPrice());
                    System.out.println("Your new total is : " + currentCust.getOrder().getOrderTotal());
                }
                System.out.println("Input was not found in our menu!");

            }
            else if(choice == REMOVE_ITEM){ //removing an item from a customers order
                System.out.println("Enter the name of the menu item: ");
                String menuItemChosen = scStr.nextLine().toLowerCase();
                FoodAndDrinks foodChosen = FoodAndDrinks.findFoodByName(currentMenu, menuItemChosen);
                if (foodChosen != null && currentCust.getOrder().getListOfFoods().indexOf(foodChosen) != -1){
                    currentCust.getOrder().getListOfFoods().remove(foodChosen);
                    currentCust.getOrder().setOrderTotal(currentCust.getOrder().getOrderTotal() -
                            foodChosen.getPrice());
                    System.out.println("Your new total is : " + currentCust.getOrder().getOrderTotal());
                }
            }
            else if(choice == CHECK_TOTAL){
                System.out.println("Your total is : " + currentCust.getOrder().getOrderTotal());
            }
            else if(choice == DISPLAY_MENU){
                printFoodAndDrinkOptions();
            }
            else if (choice == PAY){
                System.out.println("Your total is : " + currentCust.getOrder().getOrderTotal());
            }
            else {
                System.out.println("Your order has been cancelled");
            }

        }

    }
    public static void printFoodAndDrinkOptions(){
        for (int i = 0; i < currentMenu.size(); i++){
            System.out.println(currentMenu.get(i).getName() + " Price: " + currentMenu.get(i).getPrice());
        }
    }
    public static void printAdminMenu (){
        System.out.println("1: Add item to menu");
        System.out.println("2: Remove item from menu");
        System.out.println("3: Change Price Of Existing Item");
        System.out.println("4: Display Menu");
        System.out.println("5: Exit");
    }

}
