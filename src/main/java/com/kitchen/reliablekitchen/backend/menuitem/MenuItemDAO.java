package com.kitchen.reliablekitchen.backend.menuitem;

import java.util.List;

public interface MenuItemDAO {
    List<IMenuItem> findAll(MenuItemDAO iFoodbeverageDatabase);
    List<String> insert(IMenuItem foodbeverage, MenuItemDAO ifoodbeverageDatabase);
    List<String> getFoodBeverageID(String name, MenuItemDAO iFoodbeverageDatabase);
}
