package com.shop.clothes;

public class ChildrenClothes extends Clothes {
    private int sale;

    public ChildrenClothes(String name, int price, int sale) {
        super(name, price);
        this.sale = sale;
    }
    public int getPriceWithSale() {
        return Math.round(getPrice() * (1 - (float)this.sale / 100));
    }

    @Override
    public void displayInfo() {
        System.out.println("Children - Name: " + getName() + ", Price: " + getPrice() + ", Sale: " + sale + "%, Sale Price: " + getPriceWithSale());
    }
}