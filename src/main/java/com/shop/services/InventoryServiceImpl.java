package com.shop.services;

import com.shop.managers.InventoryManager;
import com.shop.clothes.Clothes;
import com.shop.clothes.ChildrenClothes;
import com.shop.clothes.ManClothes;
import com.shop.clothes.WomanClothes;
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
        switch (type) {
            case Constants.CHILDREN_CLOTHES:
                System.out.print(Constants.ENTER_SALE_PERCENTAGE);
                int sale = inputService.getIntInput();
                newItem = new ChildrenClothes(name, price, sale);
                break;
            case Constants.MAN_CLOTHES:
                newItem = new ManClothes(name, price);
                break;
            case Constants.WOMAN_CLOTHES:
                newItem = new WomanClothes(name, price);
                break;
            default:
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
