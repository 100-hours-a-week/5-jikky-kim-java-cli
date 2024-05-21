package com.shop.services;

import java.util.Scanner;

public class ScannerInputService implements InputService {
    private final Scanner scanner;

    public ScannerInputService() {
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
