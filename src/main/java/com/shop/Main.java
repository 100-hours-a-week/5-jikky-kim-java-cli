package com.shop;

import com.shop.pos.Pos;
import com.shop.utils.Constants;
import com.shop.services.ScannerInputService;
import com.shop.services.InputService;

public class Main {
    public static void main(String[] args) {
        Constants.printKcsShopArt();
        InputService inputService = new ScannerInputService();
        Pos pos = new Pos(inputService);

        pos.run();

        ((ScannerInputService) inputService).close();
    }
}
