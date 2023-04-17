package com.kitchen.reliablekitchen.backend.shortfall;

import com.kitchen.reliablekitchen.backend.ingredients.IIngredients;
import com.kitchen.reliablekitchen.backend.kitchenfactory.Kitchen;
import java.util.List;

public class ShortfallOrderItem implements IShortfallOrderItem {

  private String retailerOrderId;
  private String ingredientId;
  private String ingredientName;
  private int shortfallQuantity;

  ShortfallOrderItemDatabase shortfallOrderItemDatabase = new ShortfallOrderItemDatabase();

  public String getIngredientName() {
    return ingredientName;
  }

  public void setIngredientName(String ingredientName) {
    this.ingredientName = ingredientName;
  }

  public String getRetailerOrderId() {
    return retailerOrderId;
  }

  public void setRetailerOrderId(String retailerOrderId) {
    this.retailerOrderId = retailerOrderId;
  }

  public String getIngredientId() {
    return ingredientId;
  }

  public void setIngredientId(String ingredientId) {
    this.ingredientId = ingredientId;
  }

  public int getShortfallQuantity() {
    return shortfallQuantity;
  }

  public void setShortfallQuantity(int shortfallQuantity) {
    this.shortfallQuantity = shortfallQuantity;
  }

  public boolean createShortfallOrderItem(ShortfallOrderItemDAO sItemDAO) {
    return shortfallOrderItemDatabase.insertRetailerOrderList(this);
  }

  public List<IShortfallOrderItem> getAllShortfallOrderItems(
    ShortfallOrderItemDAO sItemDAO
  ) {
    return shortfallOrderItemDatabase.findAllById(this);
  }

  public boolean createShortfallOrderItemList(
    List<IIngredients> ingredientsList,
    String retailerOrderId,
    ShortfallOrderItemDAO sItemDAO
  ) {
    for (IIngredients shortfallIngredient : ingredientsList) {
      IShortfallOrderItem shortfallOrderItem = Kitchen
        .Instance()
        .kitchenFactory.MakeShortFallOrderItem();
      shortfallOrderItem.setIngredientId(shortfallIngredient.getId());
      shortfallOrderItem.setRetailerOrderId(retailerOrderId);
      shortfallOrderItem.setShortfallQuantity(
        shortfallIngredient.getThresholdQuantity() -
        shortfallIngredient.getAvailableQuantity()
      );
      shortfallOrderItem.setIngredientName(shortfallIngredient.getName());
      shortfallOrderItem.createShortfallOrderItem(sItemDAO);
    }
    return true;
  }
}
