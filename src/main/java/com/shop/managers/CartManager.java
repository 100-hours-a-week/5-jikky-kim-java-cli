package com.shop.managers;

import com.shop.clothes.Clothes;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private List<Clothes> cart;

    public CartManager() {
        cart = new ArrayList<>();
    }

    public void addItemToCart(Clothes item) {
        cart.add(item);
    }

    public void clearCart() {
        cart.clear();
    }

    public List<Clothes> getCart() {
        return cart;
    }
}
