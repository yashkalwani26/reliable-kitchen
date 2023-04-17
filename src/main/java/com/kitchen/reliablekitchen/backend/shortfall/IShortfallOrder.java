package com.kitchen.reliablekitchen.backend.shortfall;

import java.util.List;

import com.kitchen.reliablekitchen.backend.ingredients.IngredientDAO;

public interface IShortfallOrder {
    public String getRetailerOrderId();

      public void setRetailerOrderId(String retailerOrderId);

      public String getOrderTimestamp();

      public void setOrderTimestamp(String orderTimestamp);

      public String createRetailerOrder(ShortfallOrderDAO sDao);

      public List<IShortfallOrder> getAllShortfallOrders(ShortfallOrderDAO sDao);

      public boolean initiateOrderToRetailer(
        IngredientDAO ingredientDAO,
        ShortfallOrderDAO sDao,
        ShortfallOrderItemDAO sItemDAO
      );

}
