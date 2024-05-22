package com.shop.services;

import com.shop.utils.InputService;

public interface InventoryService {
    void addItemToInventory(InputService inputService);
    void displayInventory();
    void removeItemFromInventory(InputService inputService);
}
