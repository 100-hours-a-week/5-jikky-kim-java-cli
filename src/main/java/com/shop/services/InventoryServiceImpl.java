package com.shop.services;

import com.shop.managers.InventoryManager;
import com.shop.clothes.Clothes;
import com.shop.clothes.Children;
import com.shop.clothes.Man;
import com.shop.clothes.Woman;
import com.shop.utils.Constants;
import com.shop.utils.InputService;

import java.util.List;

public class InventoryServiceImpl implements InventoryService {
    private final InventoryManager inventoryManager;

    public InventoryServiceImpl(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    @Override
    public void addItemToInventory(InputService inputService) {
        System.out.print(Constants.ENTER_TYPE_OF_ITEM);
        int type = inputService.getIntInput();
        System.out.print(Constants.ENTER_NAME_OF_ITEM);
        String name = inputService.getInput();
        System.out.print(Constants.ENTER_PRICE_OF_ITEM);
        int price = inputService.getIntInput();

        Clothes newItem;
        if (type == 1) {
            System.out.print(Constants.ENTER_SALE_PERCENTAGE);
            int sale = inputService.getIntInput();
            newItem = new Children(name, price, sale);
        } else if (type == 2) {
            newItem = new Man(name, price);
        } else if (type == 3) {
            newItem = new Woman(name, price);
        } else {
            System.out.println(Constants.INVALID_CHOICE);
            return;
        }

        inventoryManager.addInventoryItem(newItem);
        System.out.println(Constants.ITEM_ADDED_TO_INVENTORY);
    }

    @Override
    public void displayInventory() {
        System.out.println(Constants.INVENTORY_HEADER);
        List<Clothes> inventory = inventoryManager.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            System.out.print((i + 1) + ". ");
            inventory.get(i).displayInfo();
        }
    }

    @Override
    public void removeItemFromInventory(InputService inputService) {
        System.out.print(Constants.ENTER_ITEM_NUMBER_TO_REMOVE);
        int itemNumber = inputService.getIntInput();
        inventoryManager.removeInventoryItem(itemNumber - 1);
        System.out.println(Constants.ITEM_REMOVED_FROM_INVENTORY);
    }
}
