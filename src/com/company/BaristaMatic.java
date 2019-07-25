package com.company;

import com.company.domain.Ingredient;
import com.company.domain.Recipe;
import com.company.repository.interfaces.IngredientsRepository;
import com.company.repository.interfaces.RecipesRepository;

import java.util.*;

public class BaristaMatic {

    private static final String name = "Barista-matic";

    private final RecipesRepository recipesRepository;
    private final IngredientsRepository ingredientsRepository;

    public BaristaMatic(RecipesRepository recipesRepository, IngredientsRepository ingredientsRepository) {
        this.recipesRepository = recipesRepository;
        this.ingredientsRepository = ingredientsRepository;
    }

    public Map<Recipe, Boolean> getMenu() {
        Map<Recipe, Boolean> result = new HashMap<>();

        for (Recipe recipe : recipesRepository.getAll()) {
            result.put(recipe, ingredientsRepository.checkAvailable(recipe));
        }
        return result;
    }

    public Set<Ingredient> getInventory() {
        return ingredientsRepository.getAllIngredients();
    }

    public boolean dispense(Recipe recipe) {
        if (ingredientsRepository.checkAvailable(recipe)) {
            ingredientsRepository.utilizeIngredients(recipe);
            return true;
        } else {
            return false;
        }
    }

    public void restock() {
        ingredientsRepository.restock();
    }

    public static String getName() {
        return name;
    }
}
