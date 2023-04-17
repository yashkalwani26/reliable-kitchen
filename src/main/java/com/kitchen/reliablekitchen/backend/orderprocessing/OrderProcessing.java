package com.kitchen.reliablekitchen.backend.orderprocessing;

import com.kitchen.reliablekitchen.backend.events.IObserver;
import com.kitchen.reliablekitchen.backend.ingredients.IIngredients;
import com.kitchen.reliablekitchen.backend.ingredients.IngredientDAO;
import com.kitchen.reliablekitchen.backend.menuitem.IMenuItem;
import com.kitchen.reliablekitchen.backend.menuitem.MenuItemDAO;
import com.kitchen.reliablekitchen.backend.menuitem.MenuItemIngredientDAO;
import com.kitchen.reliablekitchen.backend.ordercreation.IOrder;
import com.kitchen.reliablekitchen.backend.ordercreation.OrderDAO;

import java.util.HashMap;
import java.util.List;

public class OrderProcessing implements IObserver {

    public boolean Update(IOrder order, OrderDAO orderDB,IMenuItem menuItem, MenuItemDAO menuItemDatabase, MenuItemIngredientDAO menuItemIngredientDatabase,IngredientDAO ingredientDatabase)
    {
        HashMap<IIngredients ,Integer> ingredientsMap=requiredIngredients(order,menuItem,menuItemDatabase,menuItemIngredientDatabase);
        boolean result = matchIngredients(ingredientsMap,ingredientDatabase);
        if (result)
        {
            if(updateIngredientQuantity(ingredientsMap,ingredientDatabase))
            {
                order.updateStatusToAccepted(orderDB);
                return true;
            }
            else
            {
                order.updateStatusToDeclined(orderDB);
                return false;
            }
        }
        else {
            order.updateStatusToDeclined(orderDB);
            return false;
        }
    }
    public HashMap<IIngredients,Integer> requiredIngredients(IOrder order,IMenuItem menuItem, MenuItemDAO menuItemDatabase, MenuItemIngredientDAO menuItemIngredientDatabase)
    {
        HashMap<IIngredients ,Integer> orderIngredients=new HashMap<IIngredients,Integer>();
        for(int i = 0; i < order.getOrderList().size(); i++)
        {
            String itemName = order.getOrderList().get(i).getItem().getName();
            String foodID = menuItem.getFoodBeverageID(itemName,menuItemDatabase).get(0);
            HashMap<IIngredients ,Integer> itemIngredients = null;
            itemIngredients = menuItemIngredientDatabase.fetchNameQuantity(foodID, menuItemIngredientDatabase);
            for (IIngredients key : itemIngredients.keySet())
            {
                if(orderIngredients.containsKey(key))
                {
                    orderIngredients.put(key,orderIngredients.get(key)+itemIngredients.get(key));
                }
                else
                {
                    orderIngredients.put(key,itemIngredients.get(key)*order.getOrderList().get(i).getQuantity());
                }
            }
        }
        return orderIngredients;
    }
    public boolean matchIngredients(HashMap<IIngredients, Integer> lists,IngredientDAO ingredientDatabase)
    {
        for(IIngredients s: lists.keySet())
        {
            if(!s.validateRequiredQuantity(ingredientDatabase,lists.get(s)))
            {
                return false;
            }
        }
        return true;
    }
    public boolean updateIngredientQuantity(HashMap<IIngredients, Integer> ingredientsMap,IngredientDAO ingredientDatabase)
    {
        for (IIngredients key : ingredientsMap.keySet())
        {
            List<IIngredients> ingredientsList = key.filterIngredientsById(ingredientDatabase);
            if(ingredientsList.size()<=0)
            {
                return false;
            }
            else {
                IIngredients ingredient= ingredientsList.get(0);
                int availableQuantity = ingredient.getAvailableQuantity();
                availableQuantity = availableQuantity - ingredientsMap.get(key);
                key.setAvailableQuantity(availableQuantity);
                key.updateAvaialableQuantity(ingredientDatabase);
            }
        }
        return true;
    }
}
