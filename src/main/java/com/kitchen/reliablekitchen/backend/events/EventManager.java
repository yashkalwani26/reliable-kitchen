package com.kitchen.reliablekitchen.backend.events;

import java.util.ArrayList;
import java.util.List;

import com.kitchen.reliablekitchen.backend.ingredients.IngredientDAO;
import com.kitchen.reliablekitchen.backend.menuitem.IMenuItem;
import com.kitchen.reliablekitchen.backend.menuitem.MenuItemDAO;
import com.kitchen.reliablekitchen.backend.menuitem.MenuItemIngredientDAO;
import com.kitchen.reliablekitchen.backend.ordercreation.IOrder;
import com.kitchen.reliablekitchen.backend.ordercreation.OrderDAO;

public class EventManager {
    private static List<IObserver> listeners = null;

    public EventManager() {
      super();
      listeners = listenersList();
    }

    public static List<IObserver> listenersList()
    {
      if (listeners == null) {
        listeners = new ArrayList<IObserver>();
      }
      return listeners;
    }

    public void subscribe(final IObserver observer)
    {
      listeners.add(observer);
    }

    public void unsubscribe(final IObserver observer)
    {
      listeners.remove(observer);
    }

    public void notifyEvent(IOrder order, OrderDAO orderDB, IMenuItem foodbeverage, MenuItemDAO foodbeverageDatabase, MenuItemIngredientDAO foodbeverageIngredientDatabase, IngredientDAO ingredientDatabase) {
      for (int i = 0; i < listeners.size(); i++) {
        listeners.get(i).Update(order,orderDB,foodbeverage,foodbeverageDatabase,foodbeverageIngredientDatabase,ingredientDatabase);
      }
    }
}
