package com.kitchen.reliablekitchen.backend.menuitem;

import com.kitchen.reliablekitchen.backend.ingredients.IIngredients;
import com.kitchen.reliablekitchen.backend.kitchenfactory.Kitchen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuItemIngredientTest {

    IMenuItemIngredient menuItemIngredient = Kitchen.Instance().kitchenFactory.MakeMenuItemIngredient();
    MenuItemIngredientDBMock menuItemIngredientDBMock = new MenuItemIngredientDBMock();
    IMenuItemIngredient menuItemIngredient1 = new MenuItemIngredient("4", "D", "40");

    @Test
    public void getFoodbeverageIDTest(){
        String result = menuItemIngredient1.getFoodbeverageID();
        Assertions.assertEquals(result,"4");
    }

    @Test
    public void setFoodbeverageIDTest(){
        menuItemIngredient1.setFoodbeverageID("5");
        Assertions.assertEquals(menuItemIngredient1.getFoodbeverageID(),"5");
    }

    @Test
    public void getIngredientIDTest(){
        String result = menuItemIngredient1.getIngredientID();
        Assertions.assertEquals(result,"D");
    }

    @Test
    public void setIngredientIDTest(){
        menuItemIngredient1.setIngredientID("E");
        Assertions.assertEquals(menuItemIngredient1.getIngredientID(),"E");
    }

    @Test
    public void getRequiredQuantityTest(){
        String result = menuItemIngredient1.getRequiredQuantity();
        Assertions.assertEquals(result,"40");
    }

    @Test
    public void setRequiredQuantityTest(){
        menuItemIngredient1.setRequiredQuantity("50");
        Assertions.assertEquals(menuItemIngredient1.getRequiredQuantity(),"50");
    }

    @Test
    public void saveFoodbeverageIngredientPassTest(){
        //Pass test case
        String uid = "F";
        ArrayList<String> menuitem = new ArrayList<>();
        menuitem.add("6");
        menuitem.add("40");
        List<Boolean> result = menuItemIngredient1.saveFoodbeverageingredient(menuitem, uid, menuItemIngredientDBMock);
        Assertions.assertEquals(result.get(0), true);


    }

    @Test
    public void saveFoodbeverageIngredientFail2Test(){
        //Fail test case
        String uid = "F";
        ArrayList<String> menuitem = new ArrayList<>();

        List<Boolean> result = menuItemIngredient1.saveFoodbeverageingredient(menuitem, uid, menuItemIngredientDBMock);
        Assertions.assertEquals(result.get(0), false);
    }

    @Test
    public void saveFoodbeverageIngredientFailTest(){
        //Fail test case
        String uid = "";
        ArrayList<String> menuitem = new ArrayList<>();
        menuitem.add("6");
        menuitem.add("40");
        List<Boolean> result = menuItemIngredient1.saveFoodbeverageingredient(menuitem, uid, menuItemIngredientDBMock);
        Assertions.assertEquals(result.get(0), false);
    }
    @Test
    public void findNameQuantityPassTest(){
        //Pass test cases
        HashMap<IIngredients, Integer> result = menuItemIngredient.findNameQuantity("A", menuItemIngredientDBMock);
        for( Integer value : result.values()){
            Assertions.assertEquals(value, 10);
        }
    }

    @Test
    public void findNameQuantityFailTest(){
        //Fail test cases
        HashMap<IIngredients, Integer> result = menuItemIngredient.findNameQuantity("L", menuItemIngredientDBMock);
        for( Integer value : result.values()){
            Assertions.assertEquals(value, 0);
        }
    }

    @Test
    public void findNameStringQuantityPassTest(){
        //Pass test cases
        HashMap<String, Integer> result = menuItemIngredient.findNameStringQuantity("A", menuItemIngredientDBMock);
        for( String key : result.keySet()){
            Assertions.assertEquals(key, "1");
        }
        for( Integer value : result.values()){
            Assertions.assertEquals(value, 10);
        }
    }

    @Test
    public void findNameStringQuantityFailTest(){
        //Fail test cases
        HashMap<String, Integer> result = menuItemIngredient.findNameStringQuantity("K", menuItemIngredientDBMock);
        for( String key : result.keySet()){
            Assertions.assertEquals(key, "0");
        }
        for( Integer value : result.values()){
            Assertions.assertEquals(value, 0);
        }
    }

    @Test
    public void findByFoodIDPassTest(){
        //Pass test cases
        List<IIngredients> result = menuItemIngredient.findByFoodID("A", menuItemIngredientDBMock);
        Assertions.assertEquals(result.get(0).getId(), "1");
    }

    @Test
    public void findByFoodIDFailTest(){
        //Fail test cases
        List<IIngredients> result = menuItemIngredient.findByFoodID("L", menuItemIngredientDBMock);
        Assertions.assertEquals(result.get(0).getId(), "0");
    }
}
