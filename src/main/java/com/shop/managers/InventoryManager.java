package com.shop.managers;

import com.shop.clothes.ChildrenClothes;
import com.shop.clothes.Clothes;
import com.shop.clothes.ManClothes;
import com.shop.clothes.WomanClothes;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private List<Clothes> inventory;

    public InventoryManager() {
        inventory = new ArrayList<>();
        initInventory();
    }

    private void initInventory() {
        inventory.add(new ChildrenClothes("Shirt", 15000,20));
        inventory.add(new ManClothes("Jeans", 49900));
        inventory.add(new ManClothes("Shirt", 29000));
        inventory.add(new ManClothes("Suit", 120000));
        inventory.add(new WomanClothes("Dress", 39900));
        inventory.add(new WomanClothes("Pants", 13900));
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
