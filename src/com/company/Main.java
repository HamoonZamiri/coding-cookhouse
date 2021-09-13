package com.company;
import java.util.*;

public class Main {

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
            printCustomerMenu();
        }
        else {
            System.out.println("Invalid Selection!");
            System.out.println("1: Manager use\n2: Take an order\n-1: Exit");
        }
    }
    System.out.println("Cooking CodeHouse Software Terminated!");
    }



    public static void printCustomerMenu (){
        System.out.println("1: Add item to total");
        System.out.println("2: Remove item from order");
        System.out.println("3: Check Total");
        System.out.println("4: Pay for Order");
        System.out.println("5: Cancel Order and Exit");

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
