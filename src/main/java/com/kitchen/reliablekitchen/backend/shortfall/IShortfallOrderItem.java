package com.kitchen.reliablekitchen.backend.shortfall;

import java.util.List;

import com.kitchen.reliablekitchen.backend.ingredients.IIngredients;

public interface IShortfallOrderItem {
    public String getIngredientName();

      public void setIngredientName(String ingredientName);

      public String getRetailerOrderId();

      public void setRetailerOrderId(String retailerOrderId);

      public String getIngredientId();

      public void setIngredientId(String ingredientId);

      public int getShortfallQuantity();

      public void setShortfallQuantity(int shortfallQuantity);

      public boolean createShortfallOrderItem(ShortfallOrderItemDAO sItemDAO);

      public List<IShortfallOrderItem> getAllShortfallOrderItems(ShortfallOrderItemDAO sItemDAO);

      public boolean createShortfallOrderItemList(List<IIngredients> ingredientsList, String retailerOrderId, ShortfallOrderItemDAO sItemDAO );
}
