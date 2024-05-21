package com.shop.pos;

import com.shop.user.Admin;
import com.shop.user.User;
import com.shop.utils.Constants;
import com.shop.services.InputService;
import com.shop.services.InventoryService;
import com.shop.services.CartService;
import com.shop.managers.InventoryManager;
import com.shop.managers.CartManager;
import com.shop.managers.UserManager;

public class Pos {
    private final InventoryService inventoryService;
    private final CartService cartService;
    private final UserManager userManager;
    private final InputService inputService;

    public Pos(InputService inputService) {
        InventoryManager inventoryManager = new InventoryManager();
        CartManager cartManager = new CartManager();
        this.inventoryService = new InventoryService(inventoryManager);
        this.cartService = new CartService(cartManager, inventoryManager);
        this.userManager = new UserManager();
        this.inputService = inputService;
    }

    public void run() {
        User user = login();
        if (user != null) {
            showMenu(user);
        }
    }

    private User login() {
        System.out.print(Constants.ENTER_USERNAME);
        String username = inputService.getInput();
        System.out.print(Constants.ENTER_PASSWORD);
        String password = inputService.getInput();
        return userManager.login(username, password);
    }

    private void showMenu(User user) {
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
            int choice = inputService.getIntInput();

            switch (choice) {
                case 1:
                    inventoryService.displayInventory();
                    break;
                case 2:
                    cartService.addItemToCart(inputService);
                    break;
                case 3:
                    cartService.viewCart();
                    break;
                case 4:
                    cartService.checkout();
                    break;
                case 5:
                    if (user instanceof Admin) {
                        ((Admin) user).manageInventory(inputService, inventoryService);
                    } else {
                        System.out.println(Constants.EXIT_MESSAGE);
                        return;
                    }
                    break;
                case 6:
                    if (user instanceof Admin) {
                        System.out.println(Constants.EXIT_MESSAGE);
                        return;
                        }
                        break;
                default:
                    System.out.println(Constants.INVALID_CHOICE);
            }
        }
    }
}
