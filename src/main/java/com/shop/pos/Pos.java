package com.shop.pos;

import com.shop.clothes.Children;
import com.shop.clothes.Clothes;
import com.shop.clothes.Man;
import com.shop.clothes.Woman;
import com.shop.user.Admin;
import com.shop.user.Customer;
import com.shop.user.User;
import com.shop.utils.Constants;

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
        System.out.print(Constants.ENTER_USERNAME);
        String username = scanner.next();
        System.out.print(Constants.ENTER_PASSWORD);
        String password = scanner.next();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                user.loginSuccess();
                return user;
            }
        }
        System.out.println(Constants.LOGIN_FAILED);
        return null;
    }

    public void showMenu(User user) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(Constants.WELCOME_MESSAGE);
            System.out.println(Constants.DEVIDE_LINE);
            System.out.println(Constants.MAIN_MENU_OPTIONS);
            if (user instanceof Admin) {
                System.out.println(Constants.ADMIN_MENU_OPTIONS);
            } else {
                System.out.println(Constants.CUSTOMER_MENU_OPTIONS);
            }
            System.out.println(Constants.DEVIDE_LINE);
            System.out.print(Constants.SELECT_OPTION);
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
                        System.out.println(Constants.EXIT_MESSAGE);
                        scanner.close();
                        return;
                    }
                    break;
                case 6:
                    if (user instanceof Admin) {
                        System.out.println(Constants.EXIT_MESSAGE);
                        scanner.close();
                        return;
                    }
                default:
                    System.out.println(Constants.INVALID_CHOICE);
            }
        }
    }

    private void viewInventory() {
        System.out.println(Constants.INVENTORY_HEADER);
        for (int i = 0; i < inventory.size(); i++) {
            System.out.print((i + 1) + ". ");
            inventory.get(i).displayInfo();
        }
    }

    private void addItemToCart(Scanner scanner) {
        System.out.print(Constants.ADD_ITEM_PROMPT);
        int itemNumber = scanner.nextInt();
        if (itemNumber > 0 && itemNumber <= inventory.size()) {
            cart.add(inventory.get(itemNumber - 1));
            System.out.println(Constants.ITEM_ADDED_TO_CART);
        } else {
            System.out.println(Constants.INVALID_ITEM_NUMBER);
        }
    }

    private void viewCart() {
        System.out.println(Constants.CART_HEADER);
        for (Clothes item : cart) {
            item.displayInfo();
        }
    }

    private void checkout() {
        int total = 0;
        System.out.println(Constants.CHECKOUT_HEADER);
        for (Clothes item : cart) {
            item.displayInfo();
            if (item instanceof Children) {
                total += ((Children) item).getPriceWithSale();
            } else {
                total += item.getPrice();
            }
        }
        System.out.println(Constants.TOTAL_HEADER + total + Constants.WON);
        System.out.println(Constants.CHECKOUT_THANK);
        System.out.println(Constants.EMPTY);
        cart.clear();
    }

    public void addInventoryItem(Scanner scanner) {
        System.out.print(Constants.ENTER_TYPE_OF_ITEM);
        int type = scanner.nextInt();
        scanner.nextLine();
        System.out.print(Constants.ENTER_NAME_OF_ITEM);
        String name = scanner.nextLine();
        System.out.print(Constants.ENTER_PRICE_OF_ITEM);
        int price = scanner.nextInt();

        Clothes newItem = null;
        if (type == 1) {
            System.out.print(Constants.ENTER_SALE_PERCENTAGE);
            int sale = scanner.nextInt();
            newItem = new Children(name, price, sale);
        } else if (type == 2) {
            newItem = new Man(name, price);
        } else if (type == 3) {
            newItem = new Woman(name, price);
        }

        if (newItem != null) {
            inventory.add(newItem);
            System.out.println(Constants.ITEM_ADDED_TO_INVENTORY);
        } else {
            System.out.println(Constants.ITEM_NOT_ADDED);
        }
    }

    public void removeInventoryItem(Scanner scanner) {
        System.out.print(Constants.ENTER_ITEM_NUMBER_TO_REMOVE);
        int itemNumber = scanner.nextInt();
        if (itemNumber > 0 && itemNumber <= inventory.size()) {
            inventory.remove(itemNumber - 1);
            System.out.println(Constants.ITEM_REMOVED_FROM_INVENTORY);
        } else {
            System.out.println(Constants.INVALID_ITEM_NUMBER);
        }
    }
}