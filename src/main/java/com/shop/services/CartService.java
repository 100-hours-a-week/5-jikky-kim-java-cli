package com.shop.services;

import com.shop.utils.InputService;

public interface CartService {
    void addItemToCart(InputService inputService);
    void viewCart();
    void checkout();
}
