package com.kitchen.reliablekitchen.backend.ingredients;

import com.kitchen.reliablekitchen.backend.kitchenfactory.Kitchen;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class IngredientsDatabaseMock implements IngredientDAO {

  private List<IIngredients> ingredientList = new ArrayList<>();

  public IngredientsDatabaseMock() {
    for (int i = 0; i < 5; i++) {
      addIngredientToMock(
        UUID.randomUUID().toString(),
        "ING" + i + 1,
        i + 5,
        i
      );
    }
  }

  void addIngredientToMock(
    String id,
    String name,
    int aQuantity,
    int tQuantity
  ) {
    IIngredients ingredient = Kitchen
      .Instance()
      .kitchenFactory.MakeIngredient();
    ingredient.setId(id);
    ingredient.setName(name);
    ingredient.setAvailableQuantity(aQuantity);
    ingredient.setThresholdQuantity(tQuantity);
    ingredientList.add(ingredient);
  }

  @Override
  public List<IIngredients> findAll() throws Exception {
    return ingredientList;
  }

  @Override
  public List<IIngredients> findById(String id) {
    List<IIngredients> ingredients = new ArrayList<>();
    for (IIngredients ingredientItem : ingredientList) {
      if (ingredientItem.getId().equals(id)) {
        ingredients.add(ingredientItem);
      }
    }
    return ingredients;
  }

  @Override
  public boolean insert(Ingredients ingredients) {
    ingredientList.add(ingredients);
    return true;
  }

  @Override
  public boolean updateIngredient(Ingredients ingredient) {
    ingredientList.add(ingredientList.indexOf(ingredient), ingredient);
    return true;
  }

  @Override
  public boolean updateAvailableQuantity(Ingredients ingredient) {
    return updateIngredient(ingredient);
  }

  @Override
  public String getIngredientId(String ingredientName) throws Exception {
    for (IIngredients ingredientItem : ingredientList) {
      if (ingredientItem.getName().equals(ingredientName)) {
        return ingredientItem.getId();
      }
    }
    return "";
  }

  @Override
  public String getIngredientName(String ingredientid) throws Exception {
    for (IIngredients ingredientItem : ingredientList) {
      if (ingredientItem.getId().equals(ingredientid)) {
        return ingredientItem.getName();
      }
    }
    return "";
  }

  @Override
  public List<IIngredients> findLesserThanThreshold() throws Exception {
    List<IIngredients> ingredients = new ArrayList<>();
    for (IIngredients ingredientItem : ingredientList) {
      if (
        ingredientItem.getAvailableQuantity() <
        ingredientItem.getThresholdQuantity()
      ) {
        ingredients.add(ingredientItem);
      }
    }
    return ingredients;
  }
}
