package com.clothes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Pos {
    // 재고 목록
    private List<Clothes> inventory;
    // 장바구니 목록
    private List<Clothes> cart;

    public Pos() {
        inventory = new ArrayList<>();
        cart = new ArrayList<>();
        initInventory();
    }

    private void initInventory() {
        inventory.add(new Children("Shirt", 15000,20));
        inventory.add(new Man("Jeans", 49900));
        inventory.add(new Man("Shirt", 29000));
        inventory.add(new Man("Suit", 120000));
        inventory.add(new Woman("Dress", 39900));
        inventory.add(new Woman("Pants", 13900));
    }

    private void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the KCS Clothing Shop Pos");
            System.out.println("-------------------------");
            System.out.println("1. View Inventory");
            System.out.println("2. Add Item to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.println("-------------------------");
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewInventory();
                    break;
                case 2:
                    addItemToCart(scanner);
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    checkout();
                    break;
                case 5:
                    System.out.println("Thank you for using. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void viewInventory() {
        System.out.println("Inventory:");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.print((i + 1) + ". ");
            inventory.get(i).displayInfo();
        }
    }

    private void addItemToCart(Scanner scanner) {
        System.out.print("Enter the item number to add to cart: ");
        int itemNumber = scanner.nextInt();
        if (itemNumber > 0 && itemNumber <= inventory.size()) {
            cart.add(inventory.get(itemNumber - 1));
            System.out.println("Item added to cart.");
        } else {
            System.out.println("Invalid item number. Please try again.");
        }
    }

    private void viewCart() {
        System.out.println("Cart:");
        for (Clothes item : cart) {
            item.displayInfo();
        }
    }

    private void checkout() {
        int total = 0;
        System.out.println("Checkout:");
        for (Clothes item : cart) {
            item.displayInfo();
            if (item instanceof Children) {
                total += ((Children) item).getPriceWithSale();
            } else {
                total += item.getPrice();
            }
        }
        System.out.println("Total : " + total + "won");
        System.out.println("Thank you!");
        System.out.println("");
        cart.clear();
    }

    public static void main(String[] args) {
        Pos pos = new Pos();
        pos.showMenu();
    }
}