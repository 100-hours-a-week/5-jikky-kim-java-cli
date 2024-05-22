package com.shop.services;

import com.shop.user.User;

public interface UserService {
    User login(String username, String password);
}
