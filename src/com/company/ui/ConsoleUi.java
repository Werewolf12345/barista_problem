package com.company.ui;

import com.company.BaristaMatic;
import com.company.domain.Ingredient;
import com.company.domain.Recipe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.*;

public class ConsoleUi {

    private final BaristaMatic baristaMatic;
    private List<Recipe> menuList;

    public ConsoleUi(BaristaMatic baristaMatic) {
        this.baristaMatic = baristaMatic;
    }

    public void displayMenu() {
        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        Map<Recipe, Boolean> menuMap = baristaMatic.getMenu();
        menuList = new ArrayList<>(menuMap.keySet());
        Collections.sort(menuList);

        System.out.println("Menu:");
        for (int i = 0; i < menuList.size(); i++) {
            System.out.println(i + 1 + "," + menuList.get(i).getName() + ","
                    + currencyFormatter.format(menuList.get(i).getPrice()) + "," +
                    menuMap.get(menuList.get(i))
            );
        }
    }

    public void displayInventory() {
        System.out.println("Inventory:");

        Set<Ingredient> inventory = new TreeSet<>(baristaMatic.getInventory());

        for (Ingredient ingredient : inventory) {
            System.out.println(ingredient.getName() + "," + ingredient.getAmount());
        }
    }

    public void inputLoop() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while (true) {
            try {
                input = reader.readLine()
                        .toLowerCase()
                        .trim();
                if (input.equals("")) {
                    continue;
                } else if (input.equals("q")) {
                    System.exit(0);
                } else if (input.equals("r")) {
                    baristaMatic.restock();
                } else if (Integer.parseInt(input) > 0 && Integer.parseInt(input) <= menuList.size()) {
                    final int selection = Integer.parseInt(input) - 1;

                    if (baristaMatic.dispense(menuList.get(selection))) {
                        System.out.println("Dispensing: " + menuList.get(selection).getName());
                    } else {
                        System.out.println("Out of stock: " + menuList.get(selection).getName());
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException | IOException e) {
                System.out.println("Invalid selection: " + input);
            }
            displayInventory();
            displayMenu();
        }
    }
}
