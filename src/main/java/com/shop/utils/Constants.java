package com.shop.utils;

public class Constants {
    public static final String WELCOME_MESSAGE = "Welcome to KCS SHOP";
    public static final String MAIN_MENU_OPTIONS = "1. View Inventory\n2. Add Item to Cart\n3. View Cart\n4. Checkout";
    public static final String ADMIN_MENU_OPTIONS = "5. Manage Inventory\n6. Exit";
    public static final String CUSTOMER_MENU_OPTIONS = "5. Exit";
    public static final String DEVIDE_LINE = "-------------------------";
    public static final String SELECT_OPTION = "Please select an option: ";
    public static final String ENTER_USERNAME = "Enter username: ";
    public static final String ENTER_PASSWORD = "Enter password: ";
    public static final String LOGIN_SUCCESS = "Login successful!";
    public static final String LOGIN_SUCCESS_CUSTOMER = "You have successfully logged in as a customer!";
    public static final String LOGIN_SUCCESS_ADMIN = "You have successfully logged in as a admin!";
    public static final String LOGIN_FAILED = "Login failed! Invalid username or password.";
    public static final String INVENTORY_HEADER = "Inventory:";
    public static final String ADD_ITEM_PROMPT = "Enter the item number to add to cart: ";
    public static final String ITEM_ADDED_TO_CART = "Item added to cart.";
    public static final String INVALID_ITEM_NUMBER = "Invalid item number. Please try again.";
    public static final String CART_HEADER = "Cart:";
    public static final String CHECKOUT_HEADER = "Checkout:";
    public static final String CHECKOUT_THANK = "Thank you for buying!";
    public static final String TOTAL_HEADER = "Total: ";
    public static final String WON = "won";
    public static final String EXIT_MESSAGE = "Thank you for using the POS System. Goodbye!";
    public static final String INVENTORY_MANAGEMENT_OPTIONS = "Inventory Management:\n1. Add Item\n2. Remove Item\n3. Back to Main Menu";
    public static final String ENTER_TYPE_OF_ITEM = "Enter the type of item (1. Children, 2. Man, 3. Woman): ";
    public static final String ENTER_NAME_OF_ITEM = "Enter the name of the item: ";
    public static final String ENTER_PRICE_OF_ITEM = "Enter the price of the item: ";
    public static final String ENTER_SALE_PERCENTAGE = "Enter the sale percentage: ";
    public static final String ITEM_ADDED_TO_INVENTORY = "Item added to inventory.";
    public static final String ITEM_NOT_ADDED = "Invalid type. Item not added.";
    public static final String ENTER_ITEM_NUMBER_TO_REMOVE = "Enter the item number to remove from inventory: ";
    public static final String ITEM_REMOVED_FROM_INVENTORY = "Item removed from inventory.";
    public static final String INVALID_CHOICE = "Invalid choice. Please try again.";

    public static void printKcsShopArt() {
        System.out.println(" _   __ _____  _____     _____  _   _  _____ ______");
        System.out.println("| | / //  __ \\/  ___|   /  ___|| | | ||  _  || ___ \\");
        System.out.println("| |/ / | /  \\/\\ `--.    \\ `--. | |_| || | | || |_/ /");
        System.out.println("|    \\ | |     `--. \\    `--. \\|  _  || | | ||  __/");
        System.out.println("| |\\  \\| \\__/\\/\\__/ /   /\\__/ /| | | |\\ \\_/ /| |");
        System.out.println("\\_| \\_/ \\____/\\____/    \\____/ \\_| |_/ \\___/ \\_|");
        System.out.println();
    }
}
