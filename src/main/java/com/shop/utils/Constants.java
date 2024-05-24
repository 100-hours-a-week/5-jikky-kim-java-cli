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

    // 사용자 로그 파일
    public static final String USER_LOG_FILE_NAME = "log/user_activity.log";

    // 로그 메시지 상수
    public static final String LOG_USER_LOGGED_IN = "User [%s] logged in.";
    public static final String LOG_USER_VIEWED_INVENTORY = "User [%s] viewed inventory.";
    public static final String LOG_USER_ADDED_ITEM_TO_CART = "User [%s] added item to cart.";
    public static final String LOG_USER_VIEWED_CART = "User [%s] viewed cart.";
    public static final String LOG_USER_CHECKED_OUT = "User [%s] checked out.";
    public static final String LOG_ADMIN_MANAGED_INVENTORY = "Admin managed inventory.";
    public static final String LOG_USER_EXITED = "User [%s] exited.";

    //    메뉴
    public static final int DISPLAY_INVENTORY = 1;
    public static final int ADD_ITEM_TO_CART = 2;
    public static final int VIEW_CART = 3;
    public static final int CHECKOUT = 4;
    public static final int MANAGE_INVENTORY = 5;
    public static final int EXIT = 6;

    // 의류
    public static final int CHILDREN_CLOTHES = 1;
    public static final int MAN_CLOTHES = 2;
    public static final int WOMAN_CLOTHES = 3;

    // 인벤토리 메뉴
    public static final int INVENTORY_ADD_ITEM = 1;
    public static final int INVENTORY_REMOVE_ITEM = 2;
    public static final int INVENTORY_EXIT = 3;


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
