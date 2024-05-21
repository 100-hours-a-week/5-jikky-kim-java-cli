package com.shop.managers;

import com.shop.user.Admin;
import com.shop.user.Customer;
import com.shop.user.User;
import com.shop.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users;

    public UserManager() {
        users = new ArrayList<>();
        initUsers();
    }

    private void initUsers() {
        users.add(new Customer("customer", "customer"));
        users.add(new Admin("admin", "admin"));
    }

    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                user.loginSuccess();
                return user;
            }
        }
        System.out.println(Constants.LOGIN_FAILED);
        return null;
    }
}
