package com.shop.pos;

import com.shop.clothes.Children;
import com.shop.clothes.Clothes;
import com.shop.clothes.Man;
import com.shop.clothes.Woman;
import com.shop.user.Admin;
import com.shop.user.Customer;
import com.shop.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pos {
    // 재고 목록
    private List<Clothes> inventory;
    // 장바구니 목록
    private List<Clothes> cart;
    // 사용자 목록
    private List<User> users;
    public Pos() {
        inventory = new ArrayList<>();
        cart = new ArrayList<>();
        users = new ArrayList<>();
        initInventory();
        initUsers();
    }

    private void initInventory() {
        inventory.add(new Children("Shirt", 15000,20));
        inventory.add(new Man("Jeans", 49900));
        inventory.add(new Man("Shirt", 29000));
        inventory.add(new Man("Suit", 120000));
        inventory.add(new Woman("Dress", 39900));
        inventory.add(new Woman("Pants", 13900));
    }

    private void initUsers() {
        users.add(new Customer("customer", "customer"));
        users.add(new Admin("admin", "admin"));
    }

    public User login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                user.loginSuccess();
                return user;
            }
        }
        System.out.println("Login failed! Invalid username or password.");
        return null;
    }

    public void showMenu(User user) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the KCS Clothing Shop");
            System.out.println("-------------------------");
            System.out.println("1. View Inventory");
            System.out.println("2. Add Item to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            if (user instanceof Admin) {
                System.out.println("5. Manage Inventory");
                System.out.println("6. Exit");
            } else {
                System.out.println("5. Exit");
            }
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
                    if (user instanceof Admin) {
                        ((Admin) user).manageInventory(scanner, this);
                    } else {
                        System.out.println("Thank you for using the POS System. Goodbye!");
                        scanner.close();
                        return;
                    }
                    break;
                case 6:
                    if (user instanceof Admin) {
                        System.out.println("Thank you for using the POS System. Goodbye!");
                        scanner.close();
                        return;
                    }
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

    public void addInventoryItem(Scanner scanner) {
        System.out.print("Enter the type of item (1. Children, 2. Man, 3. Woman): ");
        int type = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the name of the item: ");
        String name = scanner.nextLine();
        System.out.print("Enter the price of the item: ");
        int price = scanner.nextInt();

        Clothes newItem = null;
        if (type == 1) {
            System.out.print("Enter the sale percentage: ");
            int sale = scanner.nextInt();
            newItem = new Children(name, price, sale);
        } else if (type == 2) {
            newItem = new Man(name, price);
        } else if (type == 3) {
            newItem = new Woman(name, price);
        }

        if (newItem != null) {
            inventory.add(newItem);
            System.out.println("Item added to inventory.");
        } else {
            System.out.println("Invalid type. Item not added.");
        }
    }

    public void removeInventoryItem(Scanner scanner) {
        System.out.print("Enter the item number to remove from inventory: ");
        int itemNumber = scanner.nextInt();
        if (itemNumber > 0 && itemNumber <= inventory.size()) {
            inventory.remove(itemNumber - 1);
            System.out.println("Item removed from inventory.");
        } else {
            System.out.println("Invalid item number. Please try again.");
        }
    }
}