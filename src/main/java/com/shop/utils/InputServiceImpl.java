package com.shop.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputServiceImpl implements InputService {
    private final Scanner scanner;

    public InputServiceImpl() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String getInput() {
        return scanner.next();
    }

    @Override
    public int getIntInput() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(Constants.INVALID_CHOICE);
                System.out.print(Constants.SELECT_OPTION);
                scanner.next();
            }
        }
    }

    public void close() {
        scanner.close();
    }
}
