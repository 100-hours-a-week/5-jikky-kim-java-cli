package com.shop;
import com.shop.pos.Pos;
import com.shop.user.User;
import com.shop.utils.Constants;

import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Constants.printKcsShopArt();
        Pos pos = new Pos();
        Scanner scanner = new Scanner(System.in);

        User user;
        do {
            user = pos.login(scanner);
        } while (user == null);
        pos.showMenu(user);
    }
}