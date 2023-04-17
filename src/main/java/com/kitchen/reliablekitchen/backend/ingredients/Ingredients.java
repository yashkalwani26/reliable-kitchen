package com.kitchen.reliablekitchen.backend.ingredients;

import java.util.List;
import java.util.UUID;

public class Ingredients implements IIngredients{

  private String id;
  private String name = null;
  private int availableQuantity = 0;
  private int thresholdQuantity = 0;

  public Ingredients() {
    this.id = "ING-" + UUID.randomUUID().toString();
  }

  public Ingredients(final String name, final int quantity) {
    this.name = name;
    this.availableQuantity = 0;
    this.id = "ING-" + UUID.randomUUID().toString();
  }

  public int getThresholdQuantity() {
    return thresholdQuantity;
  }

  public void setThresholdQuantity(int threshold) {
    this.thresholdQuantity = threshold;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public int getAvailableQuantity() {
    return availableQuantity;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public void setAvailableQuantity(final int quantity) {
    this.availableQuantity = quantity;
  }

  public List<IIngredients> getAllIngredients(IngredientDAO iDao) throws Exception{
    return iDao.findAll();
  }

  public List<IIngredients> filterByLessThanThreshold(IngredientDAO iDao) throws Exception {
    return iDao.findLesserThanThreshold();
  }

  public List<IIngredients> filterIngredientsById(IngredientDAO iDao) {
    return iDao.findById(this.getId());
  }

  public boolean updateAvaialableQuantity(IngredientDAO iDao) {
    return iDao.updateAvailableQuantity(this);
  }

  public boolean addIngredient(IngredientDAO iDao) {
    return iDao.insert(this);
  }

  public boolean validateRequiredQuantity(IngredientDAO iDao, int requireQuantity)
  {
    List<IIngredients> ingredientsList = iDao.findById(
      this.getId()
    );
    if (
      ingredientsList.size() > 0 &&
      ingredientsList.get(0).getAvailableQuantity() >= requireQuantity
    ) {
      return true;
    } else {
      return false;
    }
  }
}
