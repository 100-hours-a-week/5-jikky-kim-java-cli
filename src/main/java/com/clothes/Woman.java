package com.clothes;

class Woman extends Adult {
    public Woman(String name, int price) {
        super(name, price);
    }

    @Override
    public void displayInfo() {
        System.out.println("Woman - Name: " + getName() + ", Price: " + getPrice());
    }
}

