package com.shop.clothes;

public class ManClothes extends AdultClothes {
    public ManClothes(String name, int price) {
        super(name, price);
    }

    @Override
    public void displayInfo() {
        System.out.println("Man - Name: " + getName() + ", Price: " + getPrice());
    }
}