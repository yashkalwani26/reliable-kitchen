package com.kitchen.reliablekitchen.backend.menuitem;

import java.util.List;

public class MenuItem implements IMenuItem{
    private String name = null;
    private String price = null;

    public MenuItem() {}

    public String getName() {
        return name;
    }

    public String getPrice(){
        return price;
    }

    public void setPrice(String price){
        this.price = price;
    }

    public MenuItem(final String name, String price){
        this.name = name;
        this.price = price;
    }

    public List<IMenuItem> getAllFoodBeverage(MenuItemDAO iFoodbeverageDatabase) {
        return iFoodbeverageDatabase.findAll(iFoodbeverageDatabase);
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Foodbeverage [name=" + name + "] [price=" + price + "]";
    }

    public List<String> saveFoodbeverage(IMenuItem foodbeverage, MenuItemDAO iFoodbeverageDatabase) {
        return iFoodbeverageDatabase.insert(foodbeverage, iFoodbeverageDatabase);
    }

    public List<String> getFoodBeverageID(String name, MenuItemDAO iFoodbeverageDatabase)
    {
        return iFoodbeverageDatabase.getFoodBeverageID(name, iFoodbeverageDatabase);
    }
}
