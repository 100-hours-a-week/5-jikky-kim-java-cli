package com.shop;

import com.shop.monitor.LogMonitorThread;
import com.shop.pos.Pos;
import com.shop.services.*;
import com.shop.shared.SharedResource;
import com.shop.user.User;
import com.shop.utils.Constants;
import com.shop.utils.InputServiceImpl;
import com.shop.utils.InputService;
import com.shop.managers.InventoryManager;
import com.shop.managers.CartManager;
import com.shop.managers.UserManager;

import java.io.IOException;

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

        SharedResource sharedResource = new SharedResource();

        LogService logService = null;
        try {
            logService = new LogService(Constants.USER_LOG_FILE_NAME,sharedResource);
        } catch (IOException e) {
            e.getStackTrace();
            return;
        }

        LogMonitorThread logMonitorThread = new LogMonitorThread(sharedResource);
        logMonitorThread.start();

        Pos pos = new Pos(inputService, inventoryService, cartService, userService,logService);

        User user;
        do {
            user = pos.login();
        } while (user == null);
        pos.showMenu(user);

        ((InputServiceImpl) inputService).close();
        logService.close();
    }
}
