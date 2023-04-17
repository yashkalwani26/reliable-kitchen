package com.kitchen.reliablekitchen.backend.ingredients;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.kitchen.reliablekitchen.backend.kitchenfactory.Kitchen;

public class IngredientsTest {

    IngredientDAO iDao = new IngredientsDatabaseMock();
    IIngredients ingredient = Kitchen.Instance().kitchenFactory.MakeIngredient();

    @Test
    void setIdTest(){

        String id = UUID.randomUUID().toString();
        ingredient.setId(id);
        Assertions.assertEquals(ingredient.getId(), id);
    }

    @Test
    void getIdTest(){
        String id = UUID.randomUUID().toString();
        ingredient.setId(id);
        Assertions.assertEquals(ingredient.getId(), id);
    }

    @Test
    void getThresholdQuantityTest(){
        int thresholdQuantity = 10;
        ingredient.setThresholdQuantity(thresholdQuantity);
        Assertions.assertEquals(ingredient.getThresholdQuantity(), thresholdQuantity);
    }

    @Test
    void setThresholdQuantityTest(){
        int thresholdQuantity = 10;
        ingredient.setThresholdQuantity(thresholdQuantity);
        Assertions.assertEquals(ingredient.getThresholdQuantity(), thresholdQuantity);
    }

    @Test
    void getNameTest(){
        String name = "ING"+1;
        ingredient.setName(name);
        Assertions.assertEquals(ingredient.getName(), name);
    }

    @Test
    void setNameTest(){
        String name = "ING"+1;
        ingredient.setName(name);
        Assertions.assertEquals(ingredient.getName(), name);
    }

    @Test
    void getAvailableQuantityTest(){
        int availableQuantity = 10;
        ingredient.setAvailableQuantity(availableQuantity);
        Assertions.assertEquals(ingredient.getAvailableQuantity(), availableQuantity);
    }

    @Test
    void setAvailableQuantityTest(){
        int availableQuantity = 10;
        ingredient.setAvailableQuantity(availableQuantity);
        Assertions.assertEquals(ingredient.getAvailableQuantity(), availableQuantity);
    }

    @Test
    void getAllIngredientsTest() throws Exception{
        List<IIngredients> list = ingredient.getAllIngredients(iDao);
        for (int i = 0; i < 5; i++) {

              Assertions.assertEquals("ING" + i + 1,list.get(i).getName());
          }
    }

    @Test
    void filterByLessThanThresholdTest() throws Exception{
        ingredient.setAvailableQuantity(5);
        ingredient.setThresholdQuantity(10);
        ingredient.addIngredient(iDao);
        List<IIngredients> list = ingredient.filterByLessThanThreshold(iDao);
        Assertions.assertEquals(ingredient.getId(), list.get(0).getId());
    }

    @Test
    void filterIngredientsByIdTest(){
        ingredient.setId("TEST1");
        ingredient.addIngredient(iDao);
        List<IIngredients> list = ingredient.filterIngredientsById(iDao);
        Assertions.assertEquals("TEST1",list.get(0).getId());
    }

    @Test
    void updateAvaialableQuantityTest() throws Exception{
        ingredient.addIngredient(iDao);
        ingredient.setAvailableQuantity(10);
        ingredient.updateAvaialableQuantity(iDao);
        List<IIngredients> list = ingredient.filterIngredientsById(iDao);
        Assertions.assertEquals(10,list.get(0).getAvailableQuantity());
    }

    @Test
    void addIngredientTest(){
        ingredient.setId("TEST1");
        ingredient.addIngredient(iDao);
        List<IIngredients> list = ingredient.filterIngredientsById(iDao);
        Assertions.assertEquals("TEST1",list.get(0).getId());
    }

    @Test
    void validateRequiredQuantityTest(){
        ingredient.setAvailableQuantity(10);
        ingredient.addIngredient(iDao);
        Assertions.assertTrue(ingredient.validateRequiredQuantity(iDao, 5));
    }
}
