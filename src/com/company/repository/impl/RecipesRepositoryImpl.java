package com.company.repository.impl;

import com.company.domain.Ingredient;
import com.company.domain.Recipe;
import com.company.repository.interfaces.IngredientsRepository;
import com.company.repository.interfaces.RecipesRepository;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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
        return new Recipe("NOT FOUND", Collections.emptyMap());
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

        addRecipe(new Recipe("Coffee", new HashMap<Ingredient, Integer>() {
            {
                put(ingredientsRepository.getIngredientByName("Coffee"), 3);
                put(ingredientsRepository.getIngredientByName("Sugar"), 1);
                put(ingredientsRepository.getIngredientByName("Cream"), 1);
            }
        }));
        addRecipe(new Recipe("Decaf Coffee", new HashMap<Ingredient, Integer>() {
            {
                put(ingredientsRepository.getIngredientByName("Decaf Coffee"), 3);
                put(ingredientsRepository.getIngredientByName("Sugar"), 1);
                put(ingredientsRepository.getIngredientByName("Cream"), 1);
            }
        }));
        addRecipe(new Recipe("Caffe Latte", new HashMap<Ingredient, Integer>() {
            {
                put(ingredientsRepository.getIngredientByName("Espresso"), 2);
                put(ingredientsRepository.getIngredientByName("Steamed Milk"), 1);
            }
        }));
        addRecipe(new Recipe("Caffe Americano", new HashMap<Ingredient, Integer>() {
            {
                put(ingredientsRepository.getIngredientByName("Espresso"), 3);
            }
        }));
        addRecipe(new Recipe("Caffe Mocha", new HashMap<Ingredient, Integer>() {
            {
                put(ingredientsRepository.getIngredientByName("Espresso"), 1);
                put(ingredientsRepository.getIngredientByName("Cocoa"), 1);
                put(ingredientsRepository.getIngredientByName("Steamed Milk"), 1);
                put(ingredientsRepository.getIngredientByName("Whipped Cream"), 1);
            }
        }));
        addRecipe(new Recipe("Cappuccino", new HashMap<Ingredient, Integer>() {
            {
                put(ingredientsRepository.getIngredientByName("Espresso"), 2);
                put(ingredientsRepository.getIngredientByName("Steamed Milk"), 1);
                put(ingredientsRepository.getIngredientByName("Foamed Milk"), 1);
            }
        }));
    }
}
