package com.company.repository.interfaces;

import com.company.domain.Ingredient;
import com.company.domain.Recipe;

import java.util.Set;

public interface IngredientsRepository {

    int RESTOCK_AMOUNT = 10;

    double COFFEE_PRICE = 0.75;
    double DECAF_C_PRICE = 0.75;
    double SUGAR_PRICE = 0.25;
    double CREAM_PRICE = 0.25;
    double S_MILK_PRICE = 0.35;
    double F_MILK_PRICE = 0.35;
    double ESPRESSO_PRICE = 1.10;
    double COCOA_PRICE = 0.90;
    double W_CREAM_PRICE = 1.00;

    String COFFEE_INGR_NAME = "Coffee";
    String DECAF_COFFEE_INGR_NAME = "Decaf Coffee";
    String SUGAR_INGR_NAME = "Sugar";
    String CREAM_INGR_NAME = "Cream";
    String STEAMED_MILK_INGR_NAME = "Steamed Milk";
    String FOAMED_MILK_INGR_NAME = "Foamed Milk";
    String ESPRESSO_INGR_NAME = "Espresso";
    String COCOA_INGR_NAME = "Cocoa";
    String WHIPPED_CREAM_INGR_NAME = "Whipped Cream";

    boolean addIngredient(Ingredient ingredient);

    boolean deleteIngredient(Ingredient ingredient);

    void restock();

    Set<Ingredient> getAllIngredients();

    Boolean checkAvailable(Recipe recipe);

    Ingredient getIngredientByName(String name);

    void utilizeIngredients(Recipe recipe);
}
