package com.kitchen.reliablekitchen.backend.shortfall;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.kitchen.reliablekitchen.backend.ingredients.IIngredients;
import com.kitchen.reliablekitchen.backend.kitchenfactory.Kitchen;

public class ShortfallOrderItemTest {

  ShortfallOrderItemDAO sItemDAO = new ShortfallOrderItemDatabaseMock();
  IShortfallOrderItem shortfallOrderItem = new ShortfallOrderItem();

  @Test
  void getIngredientNameTest() {
    String ingredientName = "onion";
    shortfallOrderItem.setIngredientName(ingredientName);
    Assertions.assertEquals(
      ingredientName,
      shortfallOrderItem.getIngredientName()
    );
  }

  @Test
  void setIngredientNameTest() {
    String ingredientName = "mustard";
    shortfallOrderItem.setIngredientName(ingredientName);
    Assertions.assertEquals(
      ingredientName,
      shortfallOrderItem.getIngredientName()
    );
  }

  @Test
  void getRetailerOrderIdTest() {
    String id = UUID.randomUUID().toString();
    shortfallOrderItem.setRetailerOrderId(id);
    Assertions.assertEquals(id, shortfallOrderItem.getRetailerOrderId());
  }

  @Test
  void setRetailerOrderIdTest() {
    String id = UUID.randomUUID().toString();
    shortfallOrderItem.setRetailerOrderId(id);
    Assertions.assertEquals(id, shortfallOrderItem.getRetailerOrderId());
  }

  @Test
  void getIngredientIdTest() {
    String id = UUID.randomUUID().toString();
    shortfallOrderItem.setIngredientId(id);
    Assertions.assertEquals(id, shortfallOrderItem.getIngredientId());
  }

  @Test
  void setIngredientIdTest() {
    String id = UUID.randomUUID().toString();
    shortfallOrderItem.setIngredientId(id);
    Assertions.assertEquals(id, shortfallOrderItem.getIngredientId());
  }

  @Test
  void setShortfallQuantityTest() {
    int shortfallQuantity = 3;
    shortfallOrderItem.setShortfallQuantity(shortfallQuantity);
    Assertions.assertEquals(
      shortfallQuantity,
      shortfallOrderItem.getShortfallQuantity()
    );
  }

  @Test
  void getShortfallQuantityTest() {
    int shortfallQuantity = 3;
    shortfallOrderItem.setShortfallQuantity(shortfallQuantity);
    Assertions.assertEquals(
      shortfallQuantity,
      shortfallOrderItem.getShortfallQuantity()
    );
  }

  @Test
  void createShortfallOrdeItemTest() {
    shortfallOrderItem.setIngredientId(UUID.randomUUID().toString());
    shortfallOrderItem.setRetailerOrderId(UUID.randomUUID().toString());
    shortfallOrderItem.setIngredientName("honey");
    shortfallOrderItem.setShortfallQuantity(4);
    Assertions.assertTrue(
      shortfallOrderItem.createShortfallOrderItem(sItemDAO)
    );
  }

  @Test
  void failureGetAllShortfallOrderItemsTest() {
    shortfallOrderItem.setRetailerOrderId("SOID1");
    List<IShortfallOrderItem> list = shortfallOrderItem.getAllShortfallOrderItems(
      sItemDAO
    );
    Assertions.assertEquals(0, list.size());
  }

  @Test
  void createShortfallOrderItemListTest() {
    List<IIngredients> ingredientList =  new ArrayList<>();
    IIngredients ingredient = Kitchen.Instance().kitchenFactory.MakeIngredient();
    ingredientList.add(ingredient);
    Assertions.assertTrue(shortfallOrderItem.createShortfallOrderItemList(ingredientList,"ROID1", sItemDAO));
  }
}
