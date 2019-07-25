package com.company;

import com.company.repository.interfaces.IngredientsRepository;
import com.company.repository.impl.IngredientsRepositoryImpl;
import com.company.repository.interfaces.RecipesRepository;
import com.company.repository.impl.RecipesRepositoryImpl;
import com.company.ui.ConsoleUi;

public class Main {
    public static void main(String[] args) {
        IngredientsRepository ingredientsRepository = new IngredientsRepositoryImpl();
        RecipesRepository recipesRepository = new RecipesRepositoryImpl(ingredientsRepository);

        BaristaMatic baristaMatic = new BaristaMatic(recipesRepository, ingredientsRepository);
        ConsoleUi consoleUi = new ConsoleUi(baristaMatic);

        consoleUi.displayInventory();
        consoleUi.displayMenu();

        consoleUi.inputLoop();
    }
}
