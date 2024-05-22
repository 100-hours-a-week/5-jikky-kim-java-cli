package com.shop.services;

import com.shop.user.User;
import com.shop.managers.UserManager;
import com.shop.utils.Constants;

public class UserServiceImpl implements UserService {
    private final UserManager userManager;

    public UserServiceImpl(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public User login(String username, String password) {
        for (User user : userManager.getUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                user.loginSuccess();
                return user;
            }
        }
        System.out.println(Constants.LOGIN_FAILED);
        return null;
    }
}
