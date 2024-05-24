package com.shop.pos;

import com.shop.services.CartService;
import com.shop.services.InventoryService;
import com.shop.services.UserService;
import com.shop.user.Admin;
import com.shop.user.User;
import com.shop.utils.Constants;
import com.shop.utils.InputService;

public class Pos {
    private final InventoryService inventoryService;
    private final CartService cartService;
    private final UserService userService;
    private final InputService inputService;

    public Pos(InputService inputService, InventoryService inventoryService, CartService cartService, UserService userService) {
        this.inventoryService = inventoryService;
        this.cartService = cartService;
        this.userService = userService;
        this.inputService = inputService;
    }

    public User login() {
        System.out.print(Constants.ENTER_USERNAME);
        String username = inputService.getInput();
        System.out.print(Constants.ENTER_PASSWORD);
        String password = inputService.getInput();
        return userService.login(username, password);
    }

    public void showMenu(User user) {
        boolean continueMenu = true;
        while (continueMenu) {
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
                case Constants.DISPLAY_INVENTORY:
                    inventoryService.displayInventory();
                    break;
                case Constants.ADD_ITEM_TO_CART:
                    cartService.addItemToCart(inputService);
                    break;
                case Constants.VIEW_CART:
                    cartService.viewCart();
                    break;
                case Constants.CHECKOUT:
                    cartService.checkout();
                    break;
                case Constants.MANAGE_INVENTORY:
                    if (user instanceof Admin) {
                        ((Admin) user).manageInventory(inputService, inventoryService);
                    } else {
                        System.out.println(Constants.EXIT_MESSAGE);
                        return;
                    }
                    break;
                case Constants.EXIT:
                    System.out.println(Constants.EXIT_MESSAGE);
                    continueMenu=false;
                default:
                    System.out.println(Constants.INVALID_CHOICE);
            }
        }
    }
}
