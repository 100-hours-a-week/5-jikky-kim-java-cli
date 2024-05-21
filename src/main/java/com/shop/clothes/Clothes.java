package com.shop.clothes;

public class Clothes {
    private String name;
    private int price;

    public Clothes(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Price: " + price);
    }
}