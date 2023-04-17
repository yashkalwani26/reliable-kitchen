package com.kitchen.reliablekitchen.backend.menuitem;

import java.util.List;

public interface IMenuItem {
    String getName();
    void setName(String Name);
    String getPrice();
    void setPrice(String Price);
    List<String> getFoodBeverageID(String name, MenuItemDAO iFoodbeverageDatabase);
    List<String> saveFoodbeverage(IMenuItem foodbeverage, MenuItemDAO iFoodbeverageDatabase);
    List<IMenuItem> getAllFoodBeverage(MenuItemDAO iFoodbeverageDatabase);
}
