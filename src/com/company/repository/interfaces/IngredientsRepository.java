package com.company.repository.interfaces;

import com.company.domain.Ingredient;
import com.company.domain.Recipe;

import java.util.Set;

public interface IngredientsRepository {
    boolean addIngredient(Ingredient ingredient);

    boolean deleteIngredient(Ingredient ingredient);

    void restock();

    Set<Ingredient> getAllIngredients();

    Boolean checkAvailable(Recipe recipe);

    Ingredient getIngredientByName(String name);

    void utilizeIngredients(Recipe recipe);
}
