package com.company.repository.interfaces;

import com.company.domain.Recipe;

import java.util.Set;

public interface RecipesRepository {

    String COFFEE_NAME = "Coffee";
    String DECAF_COFFEE_NAME = "Decaf Coffee";
    String CAFFE_LATTE_NAME = "Caffe Latte";
    String CAFFE_AMERICANO_NAME = "Caffe Americano";
    String CAFFE_MOCHA_NAME = "Caffe Mocha";
    String CAPPUCCINO_NAME = "Cappuccino";

    Set<Recipe> getAll();

    Recipe getRecipeByName(String name);

    boolean addRecipe(Recipe recipe);

    boolean deleteRecipe(Recipe recipe);
}
