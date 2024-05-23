package com.shop.clothes;

// Adult clothes class
public class AdultClothes extends Clothes {
    public AdultClothes(String name, int price) {
        super(name, price);
    }

    @Override
    public void displayInfo() {
        System.out.println("Adult - Name: " + getName() + ", Price: " + getPrice());
    }
}

