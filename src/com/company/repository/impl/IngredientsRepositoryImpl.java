package com.company.repository.impl;

import com.company.domain.Ingredient;
import com.company.domain.Recipe;
import com.company.repository.interfaces.IngredientsRepository;

import java.util.*;

public class IngredientsRepositoryImpl implements IngredientsRepository {


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
        addIngredient(new Ingredient(COFFEE_INGR_NAME, RESTOCK_AMOUNT, COFFEE_PRICE));
        addIngredient(new Ingredient(DECAF_COFFEE_INGR_NAME, RESTOCK_AMOUNT, DECAF_C_PRICE));
        addIngredient(new Ingredient(SUGAR_INGR_NAME, RESTOCK_AMOUNT, SUGAR_PRICE));
        addIngredient(new Ingredient(CREAM_INGR_NAME, RESTOCK_AMOUNT, CREAM_PRICE));
        addIngredient(new Ingredient(STEAMED_MILK_INGR_NAME, RESTOCK_AMOUNT, S_MILK_PRICE));
        addIngredient(new Ingredient(FOAMED_MILK_INGR_NAME, RESTOCK_AMOUNT, F_MILK_PRICE));
        addIngredient(new Ingredient(ESPRESSO_INGR_NAME, RESTOCK_AMOUNT, ESPRESSO_PRICE));
        addIngredient(new Ingredient(COCOA_INGR_NAME, RESTOCK_AMOUNT, COCOA_PRICE));
        addIngredient(new Ingredient(WHIPPED_CREAM_INGR_NAME, RESTOCK_AMOUNT, W_CREAM_PRICE));
    }
}
