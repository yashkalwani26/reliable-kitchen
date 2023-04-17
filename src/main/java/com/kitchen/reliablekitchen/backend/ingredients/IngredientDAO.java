package com.kitchen.reliablekitchen.backend.ingredients;

import java.util.List;

public interface IngredientDAO {

  public List<IIngredients> findAll() throws Exception;

  public List<IIngredients> findLesserThanThreshold() throws Exception;

  public List<IIngredients> findById(String id);

  public boolean insert(Ingredients ingredients);

  public boolean updateIngredient(Ingredients ingredients);

  public boolean updateAvailableQuantity(Ingredients ingredient);

  public String getIngredientId(String ingredient) throws Exception;

  public String getIngredientName(String ingredientid) throws Exception;
}
