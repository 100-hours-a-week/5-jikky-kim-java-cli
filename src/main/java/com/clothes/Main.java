package com.clothes;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Pos pos = new Pos();
        Scanner scanner = new Scanner(System.in);

        User user;
        do {
            user = pos.login(scanner);
        } while (user == null);
        pos.showMenu(user);
    }
}