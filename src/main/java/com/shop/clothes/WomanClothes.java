package com.shop.clothes;

public class WomanClothes extends AdultClothes {
    public WomanClothes(String name, int price) {
        super(name, price);
    }

    @Override
    public void displayInfo() {
        System.out.println("Woman - Name: " + getName() + ", Price: " + getPrice());
    }
}

