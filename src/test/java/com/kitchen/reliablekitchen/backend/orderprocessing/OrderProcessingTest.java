package com.kitchen.reliablekitchen.backend.orderprocessing;
import com.kitchen.reliablekitchen.backend.events.IObserver;
import com.kitchen.reliablekitchen.backend.ingredients.*;
import com.kitchen.reliablekitchen.backend.kitchenfactory.Kitchen;
import com.kitchen.reliablekitchen.backend.menuitem.*;
import com.kitchen.reliablekitchen.backend.ordercreation.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
public class OrderProcessingTest
{
    @Test
    public void matchIngredientsSuccessTest()
    {
        HashMap<IIngredients, Integer> lists = new HashMap<>();
        IIngredients ingredients = new Ingredients();
        IngredientDAO ingredientDatabase=new IngredientsDatabaseMock();
        ingredients.setId("be5531f8-8549-4da8-826f-4dac91ee13e2");
        ingredients.setName("garlic");
        ingredients.setAvailableQuantity(15);
        lists.put(ingredients, 5);
        OrderProcessing orderProcessing = new OrderProcessing();
        Assertions.assertEquals(false, orderProcessing.matchIngredients(lists,ingredientDatabase));
    }
    @Test
    public void matchIngredientsFailureTest()
    {
        HashMap<IIngredients, Integer> lists = new HashMap<>();
        IngredientDAO ingredientDatabase=new IngredientsDatabaseMock();
        IIngredients ingredients = new Ingredients();
        ingredients.setAvailableQuantity(10);
        ingredients.addIngredient(ingredientDatabase);
        lists.put(ingredients, 5);
        OrderProcessing orderProcessing = new OrderProcessing();
        Assertions.assertEquals(true, orderProcessing.matchIngredients(lists,ingredientDatabase));
    }

    @Test
    public void updateIngredientQuantityFailureTest()
    {
        IObserver orderProcessing=Kitchen.Instance().kitchenFactory.MakeOrderProcessing();
        IIngredients ingredient= Kitchen.Instance().kitchenFactory.MakeIngredient();
        IngredientDAO ingredientDatabase=new IngredientsDatabaseMock();
        HashMap<IIngredients,Integer> ingredientsMap=new HashMap<IIngredients,Integer>();
        ingredientsMap.put(ingredient,50);
        Assertions.assertEquals(false,orderProcessing.updateIngredientQuantity(ingredientsMap,ingredientDatabase) );
    }
    @Test
    public void updateIngredientQuantitySuccessfulTest()
    {
        IObserver orderProcessing=Kitchen.Instance().kitchenFactory.MakeOrderProcessing();
        IIngredients ingredient= Kitchen.Instance().kitchenFactory.MakeIngredient();
        IngredientDAO ingredientDatabase=new IngredientsDatabaseMock();
        HashMap<IIngredients,Integer> ingredientsMap=new HashMap<IIngredients,Integer>();
        ingredient.setAvailableQuantity(10);
        ingredient.addIngredient(ingredientDatabase);
        ingredientsMap.put(ingredient,2);
        Assertions.assertEquals(true,orderProcessing.updateIngredientQuantity(ingredientsMap,ingredientDatabase) );
    }
    @Test
    public void requiredIngredientsFailureTest()
    {
        IObserver orderProcessing=Kitchen.Instance().kitchenFactory.MakeOrderProcessing();
        IOrder order = Kitchen.Instance().kitchenFactory.Makeorder();
        IOrderItem orderItem = Kitchen.Instance().kitchenFactory.MakeOrderItem();
        orderItem.makeOrder("pizza",5);
        IMenuItem menuItem=Kitchen.Instance().kitchenFactory.MakeMenuItem();
        MenuItemDAO menuItemDatabase=new MenuItemDBMock();
        MenuItemIngredientDAO menuItemIngredientDatabase=new MenuItemIngredientDBMock();
        orderItem.setQuantity(5);
        order.addToList(orderItem);
        IIngredients ingredients=new Ingredients();
        ingredients.setId("A");
        HashMap<IIngredients,Integer> hash=new HashMap<IIngredients,Integer>();
        Assertions.assertNotEquals(hash,orderProcessing.requiredIngredients(order,menuItem,menuItemDatabase,menuItemIngredientDatabase));
    }
    @Test
    public void updateFailureTest()
    {
        IOrder order = Kitchen.Instance().kitchenFactory.Makeorder();
        IObserver orderProcessing=new OrderProcessing();
        IOrderItem orderItem = Kitchen.Instance().kitchenFactory.MakeOrderItem();
        orderItem.makeOrder("pizza",5);
        order.addToList(orderItem);
        OrderDAO orderDB=new OrderDatabaseMock();
        IMenuItem menuItem=new MenuItem();
        MenuItemDAO menuItemDatabase=new MenuItemDBMock();
        MenuItemIngredientDAO menuItemIngredientDatabase=new MenuItemIngredientDBMock();
        IngredientDAO ingredientDatabase=new IngredientsDatabaseMock();
        Assertions.assertEquals(false,orderProcessing.Update(order,orderDB,menuItem,menuItemDatabase,menuItemIngredientDatabase,ingredientDatabase));
    }
}
