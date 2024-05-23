package com.shop.services;

import com.shop.managers.CartManager;
import com.shop.managers.InventoryManager;
import com.shop.clothes.Clothes;
import com.shop.clothes.ChildrenClothes;
import com.shop.utils.Constants;
import com.shop.utils.InputService;

public class CartServiceImpl implements CartService {
    private final CartManager cartManager;
    private final InventoryManager inventoryManager;

    public CartServiceImpl(CartManager cartManager, InventoryManager inventoryManager) {
        this.cartManager = cartManager;
        this.inventoryManager = inventoryManager;
    }

    @Override
    public void addItemToCart(InputService inputService) {
        System.out.print(Constants.ADD_ITEM_PROMPT);
        int itemNumber = inputService.getIntInput();
        if (itemNumber > 0 && itemNumber <= inventoryManager.getInventory().size()) {
            cartManager.addItemToCart(inventoryManager.getInventory().get(itemNumber - 1));
            System.out.println(Constants.ITEM_ADDED_TO_CART);
        } else {
            System.out.println(Constants.INVALID_ITEM_NUMBER);
        }
    }

    @Override
    public void viewCart() {
        System.out.println(Constants.CART_HEADER);
        for (Clothes item : cartManager.getCart()) {
            item.displayInfo();
        }
    }

    @Override
    public void checkout() {
        int total = 0;
        System.out.println(Constants.CHECKOUT_HEADER);
        for (Clothes item : cartManager.getCart()) {
            item.displayInfo();
            if (item instanceof ChildrenClothes) {
                total += ((ChildrenClothes) item).getPriceWithSale();
            } else {
                total += item.getPrice();
            }
        }
        System.out.println(Constants.TOTAL_HEADER + total + Constants.WON);
        System.out.println(Constants.CHECKOUT_THANK);
        cartManager.clearCart();
    }
}
