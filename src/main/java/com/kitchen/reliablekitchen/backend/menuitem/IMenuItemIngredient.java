package com.kitchen.reliablekitchen.backend.menuitem;

import com.kitchen.reliablekitchen.backend.ingredients.IIngredients;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface IMenuItemIngredient {
    String getIngredientID();
    void setIngredientID(String ingredientID);
    String getFoodbeverageID();
    void setFoodbeverageID(String foodbeverageID);
    String getRequiredQuantity();
    void setRequiredQuantity(String requiredQuantity);
    List<Boolean> saveFoodbeverageingredient(ArrayList<String> foodbeverageingredient, String uid, MenuItemIngredientDAO iFoodbeverageIngredientDatabase);
    HashMap<IIngredients, Integer> findNameQuantity(String foodbeverageid, MenuItemIngredientDAO iFoodbeverageIngredientDatabase);
    HashMap<String, Integer> findNameStringQuantity(String foodbeverageid, MenuItemIngredientDAO iFoodbeverageIngredientDatabase);
    List<IIngredients> findByFoodID(String foodbeverageid, MenuItemIngredientDAO iFoodbeverageIngredientDatabase);
}
