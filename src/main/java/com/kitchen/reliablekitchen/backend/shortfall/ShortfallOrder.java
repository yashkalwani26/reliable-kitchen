package com.kitchen.reliablekitchen.backend.shortfall;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.kitchen.reliablekitchen.backend.ingredients.IIngredients;
import com.kitchen.reliablekitchen.backend.ingredients.IngredientDAO;
import com.kitchen.reliablekitchen.backend.kitchenfactory.Kitchen;

public class ShortfallOrder implements IShortfallOrder{

  private String retailerOrderId;
  private String orderTimestamp;

  public ShortfallOrder(){
    this.retailerOrderId =  UUID.randomUUID().toString();
  }

  public String getRetailerOrderId() {
    return retailerOrderId;
  }

  public void setRetailerOrderId(String retailerOrderId) {
    this.retailerOrderId = retailerOrderId;
  }

  public String getOrderTimestamp() {
    return orderTimestamp;
  }

  public void setOrderTimestamp(String orderTimestamp) {
    this.orderTimestamp = orderTimestamp;
  }

  public String createRetailerOrder(ShortfallOrderDAO sDao){
    String orderTimestamp = new Date().toString();
    this.orderTimestamp =  orderTimestamp;
    sDao.insertRetailerOrder(this);
    return this.retailerOrderId;
  }

  public List<IShortfallOrder> getAllShortfallOrders(ShortfallOrderDAO sDao){
    return sDao.findAll();
  }

  public boolean initiateOrderToRetailer(IngredientDAO ingredientDAO, ShortfallOrderDAO sDao, ShortfallOrderItemDAO sItemDAO) {

  List<IIngredients> ingredientsList = new ArrayList<IIngredients>();
  IIngredients ingredient = Kitchen.Instance().kitchenFactory.MakeIngredient();
    System.out.println("Cron for Ingredient Shortfall :: Started");
    try {
      ingredientsList = ingredient.filterByLessThanThreshold(ingredientDAO);
      if (ingredientsList.size() > 0) {
        String retailerOrderId = createRetailerOrder(sDao);
        IShortfallOrderItem shortfallOrderItem = Kitchen
          .Instance()
          .kitchenFactory.MakeShortFallOrderItem();
        shortfallOrderItem.createShortfallOrderItemList(
          ingredientsList,
          retailerOrderId,
          sItemDAO
        );
      } else {

        System.out.println("No shortfall ingredients to raise a request!");
      }
      System.out.println("Cron for Ingredient Shortfall :: End");
    } catch (Exception e) {
      System.out.println("Cron for Ingredient Shortfall :: End");

      return false;
    }
    return true;
  }
}
