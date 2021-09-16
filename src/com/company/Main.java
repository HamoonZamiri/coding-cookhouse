package com.company;
import java.util.*;
import java.io.File;

public class Main {

    ArrayList<FoodAndDrinks> currentMenu = initializeMenu();

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
    System.out.println("Cooking CodeHouse Software Terminated!");
    }
    public static ArrayList<FoodAndDrinks> initializeMenu() {
        File myFile = new File("menu.txt");
        Scanner fileReader = new Scanner(myFile);
        String [] currentMenuItem;
        ArrayList<FoodAndDrinks> returnMe = null;

        int counter = 0;

        while(fileReader.hasNextLine()){
            String data = fileReader.nextLine();
            currentMenuItem = data.split(",");
            FoodAndDrinks tempFood = new FoodAndDrinks(Double.parseDouble(currentMenuItem[0]),currentMenuItem[1],
                    currentMenuItem[2], Boolean.parseBoolean(currentMenuItem[3]));

            returnMe.add(counter, tempFood);
            counter++;

        }
        return returnMe;
    }
    public static void customerChoices (){
        int choice = 0;
        final int EXIT = 6;
        final int ADD_ITEM = 1;
        final int REMOVE_ITEM = 2;
        final int CHECK_TOTAL = 3;
        final int PAY = 4;
        final int DISPLAY_MENU = 5;

        Scanner scNums = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        System.out.println("Customers name: ");
        String custName = scStr.nextLine();

        ArrayList<FoodAndDrinks> orderList = null; //Order for the current customer
        Order customersOrder = new Order(orderList, 0);

        Customer currentCust = new Customer(custName, customersOrder); //initialize instance of the current customer

        //displaying menu options for customer
        System.out.println("1: Add item to order");
        System.out.println("2: Remove item from order");
        System.out.println("3: Check Total");
        System.out.println("4: Pay for Order");
        System.out.println("5: Display Menu Options");
        System.out.println("6: Cancel Order and Exit");

        choice = scNums.nextInt();
        while (choice != EXIT){
            if (choice == 1){
                System.out.println("Enter the name of the menu item: ");
                String menuItemChosen = scStr.nextLine().toLowerCase();
            }

        }

    }
    public static void printAdminMenu (){
        System.out.println("1: Add item to menu");
        System.out.println("2: Remove item from menu");
        System.out.println("3: Change Price Of Existing Item");
        System.out.println("4: Pay for Order");
    }
    public void addToOrder(Customer c){

    }
}
