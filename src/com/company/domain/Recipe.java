package com.company.domain;

import java.util.Map;

public class Recipe implements Comparable{

    private final String name;
    private Map<Ingredient, Integer> components;

    public Recipe(String name, Map<Ingredient, Integer> components) {
        this.name = name;
        this.components = components;
    }

    public double getPrice() {
        double price = 0;

        for (Map.Entry<Ingredient, Integer> entry : components.entrySet()) {
            price += entry.getKey().getPrice() * entry.getValue();
        }

        return price;
    }

    public String getName() {
        return name;
    }

    public Map<Ingredient, Integer> getComponents() {
        return components;
    }

    public void setComponents(Map<Ingredient, Integer> components) {
        this.components = components;
    }

    @Override
    public int compareTo(Object o) {
        return this.getName().compareTo(((Recipe)o).getName());
    }
}
