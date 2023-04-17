package com.kitchen.reliablekitchen.backend.menuitem;

import com.kitchen.reliablekitchen.backend.ingredients.IIngredients;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuItemIngredient implements IMenuItemIngredient {
    private String foodbeverageid;
    private String ingredientid;
    private String requiredQuantity;

    public MenuItemIngredient()
    {}

    public MenuItemIngredient(final String fid, String iid, String quan){
        this.foodbeverageid = fid;
        this.ingredientid = iid;
        this.requiredQuantity = quan;
    }

    public String getFoodbeverageID(){
        return foodbeverageid;
    }

    public void setFoodbeverageID(String foodbeverageid){
        this.foodbeverageid = foodbeverageid;
    }

    public String getIngredientID(){
        return ingredientid;
    }

    public void setIngredientID(String ingredientid){
        this.ingredientid = ingredientid;
    }

    public String getRequiredQuantity(){
        return requiredQuantity;
    }

    public void setRequiredQuantity(String requiredQuantity){
        this.requiredQuantity = requiredQuantity;
    }

    public String toString() {
        return "FoodbeverageIngredient [foodbeverageid=" + foodbeverageid + "] " +
                "ingredientid=" + ingredientid + "] [requiredquantity=" + requiredQuantity + "]";
    }

    public List<Boolean> saveFoodbeverageingredient(ArrayList<String> foodbeverageingredient, String uid, MenuItemIngredientDAO iFoodbeverageIngredientDatabase) {
        return iFoodbeverageIngredientDatabase.insert(foodbeverageingredient, uid, iFoodbeverageIngredientDatabase);
    }

    public HashMap<IIngredients, Integer> findNameQuantity(String foodbeverageid, MenuItemIngredientDAO iFoodbeverageIngredientDatabase){
        return iFoodbeverageIngredientDatabase.fetchNameQuantity(foodbeverageid, iFoodbeverageIngredientDatabase);
    }

    public HashMap<String, Integer> findNameStringQuantity(String foodbeverageid, MenuItemIngredientDAO iFoodbeverageIngredientDatabase){
        return iFoodbeverageIngredientDatabase.findNameStringQuantity(foodbeverageid, iFoodbeverageIngredientDatabase);
    }

    public List<IIngredients> findByFoodID(String foodbeverageid, MenuItemIngredientDAO iFoodbeverageIngredientDatabase){
        return iFoodbeverageIngredientDatabase.fetch(foodbeverageid, iFoodbeverageIngredientDatabase);
    }
}
