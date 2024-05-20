package com.clothes;

class Man extends Adult {
    public Man(String name, int price) {
        super(name, price);
    }

    @Override
    public void displayInfo() {
        System.out.println("Man - Name: " + getName() + ", Price: " + getPrice());
    }
}