package com.company.repository.impl;

import com.company.domain.Ingredient;
import com.company.domain.Recipe;
import com.company.repository.interfaces.IngredientsRepository;
import com.company.repository.interfaces.RecipesRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static com.company.Constants.*;

public class RecipesRepositoryImpl implements RecipesRepository {

    private final Set<Recipe> recipes;
    private final IngredientsRepository ingredientsRepository;

    public RecipesRepositoryImpl(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
        recipes = new HashSet<>();

        setInitialData();
    }

    @Override
    public Set<Recipe> getAll() {
        return  recipes;
    }

    @Override
    public Recipe getRecipeByName(String name) {
        for (Recipe recipe : recipes) {
            if (recipe.getName().equals(name)) {
                return recipe;
            }
        }
        return null;
    }

    @Override
    public boolean addRecipe(Recipe recipe) {
        return recipes.add(recipe);
    }

    @Override
    public boolean deleteRecipe(Recipe recipe) {
        return recipes.remove(recipe);
    }

    private void setInitialData() {
        addRecipe(new Recipe(COFFEE_NAME, new HashMap<Ingredient, Integer>() {
            {
                put(ingredientsRepository.getIngredientByName(COFFEE_INGR_NAME), 3);
                put(ingredientsRepository.getIngredientByName(SUGAR_INGR_NAME), 1);
                put(ingredientsRepository.getIngredientByName(CREAM_INGR_NAME), 1);
            }
        }));
        addRecipe(new Recipe(DECAF_COFFEE_NAME, new HashMap<Ingredient, Integer>() {
            {
                put(ingredientsRepository.getIngredientByName(DECAF_COFFEE_INGR_NAME), 3);
                put(ingredientsRepository.getIngredientByName(SUGAR_INGR_NAME), 1);
                put(ingredientsRepository.getIngredientByName(CREAM_INGR_NAME), 1);
            }
        }));
        addRecipe(new Recipe(CAFFE_LATTE_NAME, new HashMap<Ingredient, Integer>() {
            {
                put(ingredientsRepository.getIngredientByName(ESPRESSO_INGR_NAME), 2);
                put(ingredientsRepository.getIngredientByName(STEAMED_MILK_INGR_NAME), 1);
            }
        }));
        addRecipe(new Recipe(CAFFE_AMERICANO_NAME, new HashMap<Ingredient, Integer>() {
            {
                put(ingredientsRepository.getIngredientByName(ESPRESSO_INGR_NAME), 3);
            }
        }));
        addRecipe(new Recipe(CAFFE_MOCHA_NAME, new HashMap<Ingredient, Integer>() {
            {
                put(ingredientsRepository.getIngredientByName(ESPRESSO_INGR_NAME), 1);
                put(ingredientsRepository.getIngredientByName(COCOA_INGR_NAME), 1);
                put(ingredientsRepository.getIngredientByName(STEAMED_MILK_INGR_NAME), 1);
                put(ingredientsRepository.getIngredientByName(WHIPPED_CREAM_INGR_NAME), 1);
            }
        }));
        addRecipe(new Recipe(CAPPUCCINO_NAME, new HashMap<Ingredient, Integer>() {
            {
                put(ingredientsRepository.getIngredientByName(ESPRESSO_INGR_NAME), 2);
                put(ingredientsRepository.getIngredientByName(STEAMED_MILK_INGR_NAME), 1);
                put(ingredientsRepository.getIngredientByName(FOAMED_MILK_INGR_NAME), 1);
            }
        }));
    }
}
