package com.shop.utils;

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
        return scanner.nextInt();
    }

    public void close() {
        scanner.close();
    }
}
