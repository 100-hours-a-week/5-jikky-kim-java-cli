package com.shop.managers;

import com.shop.clothes.Children;
import com.shop.clothes.Clothes;
import com.shop.clothes.Man;
import com.shop.clothes.Woman;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private List<Clothes> inventory;

    public InventoryManager() {
        inventory = new ArrayList<>();
        initInventory();
    }

    private void initInventory() {
        inventory.add(new Children("Shirt", 15000,20));
        inventory.add(new Man("Jeans", 49900));
        inventory.add(new Man("Shirt", 29000));
        inventory.add(new Man("Suit", 120000));
        inventory.add(new Woman("Dress", 39900));
        inventory.add(new Woman("Pants", 13900));
    }

    public void addInventoryItem(Clothes item) {
        inventory.add(item);
    }

    public void removeInventoryItem(int itemIndex) {
        if (itemIndex >= 0 && itemIndex < inventory.size()) {
            inventory.remove(itemIndex);
        }
    }

    public List<Clothes> getInventory() {
        return inventory;
    }

}
