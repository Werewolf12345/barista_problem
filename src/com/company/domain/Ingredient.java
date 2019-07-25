package com.company.domain;

public class Ingredient implements Comparable{

    private final String name;
    private int amount;
    private double price;

    public Ingredient(String name, int amount, double price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Object o) {
        return this.getName().compareTo(((Ingredient)o).getName());
    }
}
