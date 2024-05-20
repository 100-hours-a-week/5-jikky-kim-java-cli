package com.clothes;

import java.util.Scanner;

class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }
    @Override
    public void loginSuccess(){
        System.out.println("You have successfully logged in as a admin!");
    }
    public void manageInventory(Scanner scanner, Pos pos) {
        while (true) {
            System.out.println("Inventory Management:");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Back to Main Menu");
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    pos.addInventoryItem(scanner);
                    break;
                case 2:
                    pos.removeInventoryItem(scanner);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
