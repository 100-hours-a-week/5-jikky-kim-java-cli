package com.shop;

import com.shop.pos.Pos;
import com.shop.user.User;
import com.shop.utils.Constants;
import com.shop.utils.InputServiceImpl;
import com.shop.utils.InputService;
import com.shop.services.InventoryServiceImpl;
import com.shop.services.CartServiceImpl;
import com.shop.services.UserServiceImpl;
import com.shop.services.InventoryService;
import com.shop.services.CartService;
import com.shop.services.UserService;
import com.shop.managers.InventoryManager;
import com.shop.managers.CartManager;
import com.shop.managers.UserManager;

public class Main {
    public static void main(String[] args) {
        Constants.printKcsShopArt();

        InputService inputService = new InputServiceImpl();
        InventoryManager inventoryManager = new InventoryManager();
        CartManager cartManager = new CartManager();
        UserManager userManager = new UserManager();

        InventoryService inventoryService = new InventoryServiceImpl(inventoryManager);
        CartService cartService = new CartServiceImpl(cartManager, inventoryManager);
        UserService userService = new UserServiceImpl(userManager);

        Pos pos = new Pos(inputService, inventoryService, cartService, userService);

        User user;
        do {
            user = pos.login();
        } while (user == null);
        pos.showMenu(user);

        // InputService의 Scanner 객체를 닫습니다.
        ((InputServiceImpl) inputService).close();
    }
}
