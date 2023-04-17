package com.kitchen.reliablekitchen.backend.events;

import com.kitchen.reliablekitchen.backend.ingredients.IIngredients;
import com.kitchen.reliablekitchen.backend.ingredients.IngredientDAO;
import com.kitchen.reliablekitchen.backend.menuitem.IMenuItem;
import com.kitchen.reliablekitchen.backend.menuitem.MenuItemDAO;
import com.kitchen.reliablekitchen.backend.menuitem.MenuItemIngredientDAO;
import com.kitchen.reliablekitchen.backend.ordercreation.IOrder;
import com.kitchen.reliablekitchen.backend.ordercreation.OrderDAO;

import java.util.HashMap;

public interface IObserver {
    public boolean Update(IOrder order, OrderDAO orderDB, IMenuItem menuItem, MenuItemDAO menuItemDatabase, MenuItemIngredientDAO menuIeamIngredientDatabase, IngredientDAO ingredientDatabase);
    public boolean updateIngredientQuantity(HashMap<IIngredients, Integer> ingredientsMap,IngredientDAO ingredientDatabase);
    public HashMap<IIngredients,Integer> requiredIngredients(IOrder order,IMenuItem menuItem, MenuItemDAO menuItemDatabase, MenuItemIngredientDAO menuItemIngredientDatabase);


}
