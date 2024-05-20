package com.shop.user;
import com.shop.pos.Pos;
import com.shop.utils.Constants;

import java.util.Scanner;

public class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }
    @Override
    public void loginSuccess(){
        System.out.println(Constants.LOGIN_SUCCESS_ADMIN);
    }
    public void manageInventory(Scanner scanner, Pos pos) {
        while (true) {
            System.out.println(Constants.INVENTORY_MANAGEMENT_OPTIONS);
            System.out.print(Constants.SELECT_OPTION);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    pos.addInventoryItem(scanner);
                    break;
                case 2:
                    pos.removeInventoryItem(scanner);
                    break;
                case 3:
                    return;
                default:
                    System.out.println(Constants.INVALID_CHOICE);
            }
        }
    }
}
