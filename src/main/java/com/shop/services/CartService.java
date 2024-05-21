package com.shop.services;

import com.shop.clothes.Clothes;
import com.shop.managers.CartManager;
import com.shop.managers.InventoryManager;
import com.shop.clothes.Children;
import com.shop.utils.Constants;

import java.util.List;

public class CartService {
    private CartManager cartManager;
    private InventoryManager inventoryManager;

    public CartService(CartManager cartManager, InventoryManager inventoryManager) {
        this.cartManager = cartManager;
        this.inventoryManager = inventoryManager;
    }

    public void addItemToCart(InputService inputService) {
        System.out.print(Constants.ADD_ITEM_PROMPT);
        int itemNumber = inputService.getIntInput();
        List<Clothes> inventory = inventoryManager.getInventory();
        if (itemNumber > 0 && itemNumber <= inventory.size()) {
            cartManager.addItemToCart(inventory.get(itemNumber - 1));
            System.out.println(Constants.ITEM_ADDED_TO_CART);
        } else {
            System.out.println(Constants.INVALID_ITEM_NUMBER);
        }
    }

    public void viewCart() {
        System.out.println(Constants.CART_HEADER);
        for (Clothes item : cartManager.getCart()) {
            item.displayInfo();
        }
    }

    public void checkout() {
        int total = 0;
        System.out.println(Constants.CHECKOUT_HEADER);
        for (Clothes item : cartManager.getCart()) {
            item.displayInfo();
            if (item instanceof Children) {
                total += ((Children) item).getPriceWithSale();
            } else {
                total += item.getPrice();
            }
        }
        System.out.println(Constants.TOTAL_HEADER + total + Constants.WON);
        System.out.println(Constants.CHECKOUT_THANK);
        cartManager.clearCart();
    }
}
