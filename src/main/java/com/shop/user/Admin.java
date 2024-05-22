package com.shop.user;
import com.shop.utils.InputService;
import com.shop.services.InventoryService;
import com.shop.utils.Constants;

public class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void loginSuccess(){
        System.out.println(Constants.LOGIN_SUCCESS_ADMIN);
    }

    public void manageInventory(InputService inputService, InventoryService inventoryService) {
        while (true) {
            System.out.println(Constants.INVENTORY_MANAGEMENT_OPTIONS);
            System.out.print(Constants.SELECT_OPTION);
            int choice = inputService.getIntInput();

            switch (choice) {
                case 1:
                    inventoryService.addItemToInventory(inputService);
                    break;
                case 2:
                    inventoryService.removeItemFromInventory(inputService);
                    break;
                case 3:
                    return;
                default:
                    System.out.println(Constants.INVALID_CHOICE);
            }
        }
    }
}
