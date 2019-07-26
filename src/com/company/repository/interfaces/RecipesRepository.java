package com.company.repository.interfaces;

import com.company.domain.Recipe;

import java.util.Set;

public interface RecipesRepository {

    Set<Recipe> getAll();

    Recipe getRecipeByName(String name);

    boolean addRecipe(Recipe recipe);

    boolean deleteRecipe(Recipe recipe);
}
