package com.company.repository.impl;

import com.company.domain.Ingredient;
import com.company.domain.Recipe;
import com.company.repository.interfaces.IngredientsRepository;

import java.util.*;

public class IngredientsRepositoryImpl implements IngredientsRepository {
    private static final int RESTOCK_AMOUNT = 10;

    private static final double COFFEE_PRICE = 0.75;
    private static final double DECAF_C_PRICE = 0.75;
    private static final double SUGAR_PRICE = 0.25;
    private static final double CREAM_PRICE = 0.25;
    private static final double S_MILK_PRICE = 0.35;
    private static final double F_MILK_PRICE = 0.35;
    private static final double ESPRESSO_PRICE = 1.10;
    private static final double COCOA_PRICE = 0.90;
    private static final double W_CREAM_PRICE = 1.00;

    private final Set<Ingredient> ingredients;

    public IngredientsRepositoryImpl() {
        ingredients = new HashSet<>();

        setInitialData();
    }

    @Override
    public boolean addIngredient(Ingredient ingredient) {
        return ingredients.add(ingredient);
    }

    @Override
    public boolean deleteIngredient(Ingredient ingredient) {
        return ingredients.remove(ingredient);
    }

    @Override
    public void restock() {
        for (Ingredient ingredient : ingredients) {
            ingredient.setAmount(RESTOCK_AMOUNT);
        }
    }

    @Override
    public Set<Ingredient> getAllIngredients() {
        return ingredients;
    }

    @Override
    public Boolean checkAvailable(Recipe recipe) {
        Map<Ingredient, Integer> components = recipe.getComponents();

        for (Map.Entry<Ingredient, Integer> entry : components.entrySet()) {
            if (entry.getValue() > entry.getKey().getAmount()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Ingredient getIngredientByName(String name) {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equals(name)) {
                return ingredient;
            }
        }
        return new Ingredient("NOT FOUND", 0, 0);
    }

    @Override
    public void utilizeIngredients(Recipe recipe) {
        Map<Ingredient, Integer> components = recipe.getComponents();

        for (Map.Entry<Ingredient, Integer> entry : components.entrySet()) {
            entry.getKey().setAmount(entry.getKey().getAmount() - entry.getValue());
        }
    }

    private void setInitialData() {
        addIngredient(new Ingredient("Coffee", RESTOCK_AMOUNT, COFFEE_PRICE));
        addIngredient(new Ingredient("Decaf Coffee", RESTOCK_AMOUNT, DECAF_C_PRICE));
        addIngredient(new Ingredient("Sugar", RESTOCK_AMOUNT, SUGAR_PRICE));
        addIngredient(new Ingredient("Cream", RESTOCK_AMOUNT, CREAM_PRICE));
        addIngredient(new Ingredient("Steamed Milk", RESTOCK_AMOUNT, S_MILK_PRICE));
        addIngredient(new Ingredient("Foamed Milk", RESTOCK_AMOUNT, F_MILK_PRICE));
        addIngredient(new Ingredient("Espresso", RESTOCK_AMOUNT, ESPRESSO_PRICE));
        addIngredient(new Ingredient("Cocoa", RESTOCK_AMOUNT, COCOA_PRICE));
        addIngredient(new Ingredient("Whipped Cream", RESTOCK_AMOUNT, W_CREAM_PRICE));
    }
}
