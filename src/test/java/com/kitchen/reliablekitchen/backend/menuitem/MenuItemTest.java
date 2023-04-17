package com.kitchen.reliablekitchen.backend.menuitem;

import com.kitchen.reliablekitchen.backend.kitchenfactory.Kitchen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MenuItemTest{
    IMenuItem menuItem = Kitchen.Instance().kitchenFactory.MakeMenuItem();
    IMenuItem menuItem1 = new MenuItem("Pasta", "5.99");
    MenuItemDBMock menuItemDBMock = new MenuItemDBMock();

    @Test
    public void getNameTest(){
        Assertions.assertEquals(menuItem1.getName(),"Pasta");
    }

    @Test
    public void setNameTest(){
        menuItem1.setName("Maggie");
        Assertions.assertEquals(menuItem1.getName(),"Maggie");
    }

    @Test
    public void getPriceTest(){
        Assertions.assertEquals(menuItem1.getPrice(),"5.99");
    }

    @Test
    public void setPriceTest(){
        menuItem1.setPrice("6.99");
        Assertions.assertEquals(menuItem1.getPrice(),"6.99");
    }

    @Test
    public void getAllFoodBeverageTest(){
        List<IMenuItem> result = menuItem.getAllFoodBeverage(menuItemDBMock);
        List<IMenuItem> actual = new ArrayList<>();

        menuItem.setName("Pizza");
        menuItem.setPrice("5.99");
        actual.add(menuItem);

        Assertions.assertEquals(result.get(0).getName(), actual.get(0).getName());
        Assertions.assertEquals(result.get(0).getPrice(), actual.get(0).getPrice());
    }

    @Test
    public void getFoodBeverageIDPassTest(){
        //Pass test case
        List<String> result = menuItem.getFoodBeverageID("Sandwich", menuItemDBMock);
        Assertions.assertEquals(result.get(0), "2");
    }

    @Test
    public void getFoodBeverageIDFailTest(){
        //Fail test case
        List<String> result = menuItem.getFoodBeverageID("Chaat", menuItemDBMock);
        Assertions.assertEquals(result.get(0), "0");
    }

    @Test
    public void saveFoodbeverageTest(){
        menuItem.setName("Fries");
        menuItem.setPrice("100");
        List<String> result = menuItem.saveFoodbeverage(menuItem, menuItemDBMock);
        Assertions.assertEquals(result.get(0), "4");
    }
}
