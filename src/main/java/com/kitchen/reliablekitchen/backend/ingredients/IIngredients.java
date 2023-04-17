package com.kitchen.reliablekitchen.backend.ingredients;

import java.util.List;

public interface IIngredients {
    public int getThresholdQuantity();
      public void setThresholdQuantity(int threshold);

      public String getId();

      public void setId(String id);

      public String getName();

      public int getAvailableQuantity();

      public void setName(final String name);

      public void setAvailableQuantity(final int quantity);

      public List<IIngredients> getAllIngredients(IngredientDAO iDao) throws Exception;

      public List<IIngredients> filterByLessThanThreshold(IngredientDAO iDao) throws Exception;

      public List<IIngredients> filterIngredientsById(IngredientDAO iDao);

      public boolean updateAvaialableQuantity(IngredientDAO iDao);

      public boolean addIngredient(IngredientDAO iDao);

      public boolean validateRequiredQuantity(IngredientDAO iDao, int requireQuantity);
}
