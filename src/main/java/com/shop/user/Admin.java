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
                case Constants.INVENTORY_ADD_ITEM:
                    inventoryService.addItemToInventory(inputService);
                    break;
                case Constants.INVENTORY_REMOVE_ITEM:
                    inventoryService.removeItemFromInventory(inputService);
                    break;
                case Constants.INVENTORY_EXIT:
                    return;
                default:
                    System.out.println(Constants.INVALID_CHOICE);
            }
        }
    }
}
