package com.kitchen.reliablekitchen.backend.shortfall;

import com.kitchen.reliablekitchen.backend.ingredients.IIngredients;
import com.kitchen.reliablekitchen.backend.ingredients.IngredientDAO;
import com.kitchen.reliablekitchen.backend.ingredients.IngredientsDatabaseMock;
import com.kitchen.reliablekitchen.backend.kitchenfactory.Kitchen;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShortfallOrderTest {

  ShortfallOrderDAO sOrderDao = new ShortfallOrderDatabaseMock();
  IShortfallOrder shortfallOrder = Kitchen
    .Instance()
    .kitchenFactory.MakeShortFallOrder();
  IngredientDAO iDao = new IngredientsDatabaseMock();
  ShortfallOrderItemDAO sOrderItemDao = new ShortfallOrderItemDatabaseMock();

  @Test
  void getRetailerIdTest() {
    String id = UUID.randomUUID().toString();
    shortfallOrder.setRetailerOrderId(id);
    Assertions.assertEquals(shortfallOrder.getRetailerOrderId(), id);
  }

  @Test
  void setRetailerOrderIdTest() {
    String id = UUID.randomUUID().toString();
    shortfallOrder.setRetailerOrderId(id);
    Assertions.assertEquals(shortfallOrder.getRetailerOrderId(), id);
  }

  @Test
  void getOrderTimestampTest() {
    String id = new Date().toString();
    shortfallOrder.setOrderTimestamp(id);
    Assertions.assertEquals(shortfallOrder.getOrderTimestamp(), id);
  }

  @Test
  void setOrderTimestampTest() {
    String id = new Date().toString();
    shortfallOrder.setOrderTimestamp(id);
    Assertions.assertEquals(shortfallOrder.getOrderTimestamp(), id);
  }

  @Test
  void createRetailerOrderTest() {
    String expectedId = UUID.randomUUID().toString();
    shortfallOrder.setRetailerOrderId(expectedId);
    shortfallOrder.setOrderTimestamp(new Date().toString());
    String actualId = shortfallOrder.createRetailerOrder(sOrderDao);
    Assertions.assertEquals(expectedId, actualId);
  }

  @Test
  void getAllShortfallOrdersTest() {
    List<IShortfallOrder> list = shortfallOrder.getAllShortfallOrders(
      sOrderDao
    );
    for (int i = 0; i < 5; i++) {
      Assertions.assertEquals("SO" + i + 1, list.get(i).getRetailerOrderId());
    }
  }

  @Test
  void initiateOrderToRetailerTest() {
    IIngredients ingredient = Kitchen.Instance().kitchenFactory.MakeIngredient();
    ingredient.setAvailableQuantity(5);
    ingredient.setName("mustard");
    ingredient.setThresholdQuantity(4);
    ingredient.addIngredient(iDao);
    Assertions.assertTrue(shortfallOrder.initiateOrderToRetailer(iDao, sOrderDao, sOrderItemDao));
  }

}
