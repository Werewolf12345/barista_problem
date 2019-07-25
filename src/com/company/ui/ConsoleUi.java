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

    private static final String QUIT = "q";
    private static final String RESTOCK = "r";

    private static final String MENU_HEADER = "Menu:";
    private static final String INVENTORY_HEADER = "Inventory:";

    private static final String DISPENSING = "Dispensing: ";
    private static final String OUT_OF_STOCK = "Out of stock: ";
    private static final String INVALID_SELECTION = "Invalid selection: ";

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

        System.out.println(MENU_HEADER);
        for (int i = 0; i < menuList.size(); i++) {
            System.out.println(i + 1 + "," + menuList.get(i).getName() + ","
                    + currencyFormatter.format(menuList.get(i).getPrice()) + "," +
                    menuMap.get(menuList.get(i))
            );
        }
    }

    public void displayInventory() {
        Set<Ingredient> inventory = new TreeSet<>(baristaMatic.getInventory());

        System.out.println(INVENTORY_HEADER);
        for (Ingredient ingredient : inventory) {
            System.out.println(ingredient.getName() + "," + ingredient.getAmount());
        }
    }

    public void inputLoop() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        do {
            try {
                input = reader.readLine()
                        .toLowerCase()
                        .trim();
                if (input.equals("")) {
                    continue;
                } else if (input.equals(QUIT)) {
                    System.exit(0);
                } else if (input.equals(RESTOCK)) {
                    baristaMatic.restock();
                } else if (Integer.parseInt(input) > 0 && Integer.parseInt(input) <= menuList.size()) {
                    final int selection = Integer.parseInt(input) - 1;

                    if (baristaMatic.dispense(menuList.get(selection))) {
                        System.out.println(DISPENSING + menuList.get(selection).getName());
                    } else {
                        System.out.println(OUT_OF_STOCK + menuList.get(selection).getName());
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException | IOException e) {
                System.out.println(INVALID_SELECTION + input);
            }
            displayInventory();
            displayMenu();
        } while (!input.equals(QUIT));
    }
}
