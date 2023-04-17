package com.kitchen.reliablekitchen.backend.menuitem;

import com.kitchen.reliablekitchen.backend.kitchenfactory.Kitchen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuItemDBMock implements MenuItemDAO {
    List<IMenuItem> menuItems = new ArrayList<>();
    List<List<String>> menuItemsList = new ArrayList<>();
    List<String> uid = new ArrayList<>();

    public MenuItemDBMock(){
        addMenuItems();
        menuItemsList();
    }


    @Override
    public List<IMenuItem> findAll(MenuItemDAO iFoodbeverageDatabase) {
        return menuItems;
    }

    @Override
    public List<String> insert(IMenuItem foodbeverage, MenuItemDAO ifoodbeverageDatabase){
        menuItems.add(foodbeverage);
        uid.add("4");
        return uid;
    }

    @Override
    public List<String> getFoodBeverageID(String name, MenuItemDAO iFoodbeverageDatabase) {
        List<String> getID = new ArrayList<>();
        for(List<String> list : menuItemsList){
            if(list.get(1).equals(name)){
                getID.add(list.get(0));
            }
        }

        if(getID.isEmpty()){
            getID.add("0");
        }
        return getID;
    }

    public void addMenuItems(){
        IMenuItem menuItem = Kitchen.Instance().kitchenFactory.MakeMenuItem();

        menuItem.setName("Pizza");
        menuItem.setPrice("5.99");
        menuItems.add(menuItem);
    }

    public void menuItemsList(){
       menuItemsList = Arrays.asList( Arrays.asList("1", "Pizza"), Arrays.asList("2", "Sandwich"), Arrays.asList("3", "Burger"));
    }
}
