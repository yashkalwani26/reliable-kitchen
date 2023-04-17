package com.kitchen.reliablekitchen.backend.menuitem;

import com.kitchen.reliablekitchen.backend.ingredients.IIngredients;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public interface MenuItemIngredientDAO {
    List<Boolean> insert(ArrayList<String> foodbeverageingredient, String uid, MenuItemIngredientDAO iFoodbeverageIngredientDatabase);

    List<IIngredients> fetch(String foodBeverageid, MenuItemIngredientDAO iFoodbeverageIngredientDatabase);

    HashMap<String, Integer> findNameStringQuantity(String foodBeverageid, MenuItemIngredientDAO iFoodbeverageIngredientDatabase);

    HashMap<IIngredients, Integer> fetchNameQuantity(String foodBeverageid, MenuItemIngredientDAO iFoodbeverageIngredientDatabase);
}