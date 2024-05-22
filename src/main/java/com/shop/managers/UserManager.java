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

    public List<User> getUsers() {
        return users;
    }

}
