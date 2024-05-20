package com.shop;
import com.shop.pos.Pos;
import com.shop.user.User;

import java.util.Scanner;
public class Main{
    public static void printKcsShopArt() {
        System.out.println(" _   __ _____  _____     _____  _   _  _____ ______");
        System.out.println("| | / //  __ \\/  ___|   /  ___|| | | ||  _  || ___ \\");
        System.out.println("| |/ / | /  \\/\\ `--.    \\ `--. | |_| || | | || |_/ /");
        System.out.println("|    \\ | |     `--. \\    `--. \\|  _  || | | ||  __/");
        System.out.println("| |\\  \\| \\__/\\/\\__/ /   /\\__/ /| | | |\\ \\_/ /| |");
        System.out.println("\\_| \\_/ \\____/\\____/    \\____/ \\_| |_/ \\___/ \\_|");
        System.out.println();
    }
    public static void main(String[] args) {
        printKcsShopArt();
        Pos pos = new Pos();
        Scanner scanner = new Scanner(System.in);

        User user;
        do {
            user = pos.login(scanner);
        } while (user == null);
        pos.showMenu(user);
    }
}