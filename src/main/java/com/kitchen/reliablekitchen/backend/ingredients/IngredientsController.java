package com.kitchen.reliablekitchen.backend.ingredients;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kitchen.reliablekitchen.backend.kitchenfactory.Kitchen;

@Controller
public class IngredientsController {

  IngredientDAO iDao = new IngredientsDatabase();

  @RequestMapping("/ingredients")
  public ModelAndView allIngredients() {
    ModelAndView model = new ModelAndView("ingredients/AllIngredientsList");
    try{
    IIngredients ingredients = Kitchen.Instance().kitchenFactory.MakeIngredient();

    model.addObject("ingredientsList", ingredients.getAllIngredients(iDao));
    }catch (Exception e){
      model.setViewName("error");
      model.addObject("errorMsg", e.getMessage());
    }
    return model;
  }

  @RequestMapping("/add/ingredient")
  public ModelAndView addIngredient() {
    ModelAndView model = new ModelAndView("ingredients/addIngredient");
    return model;
  }

  @RequestMapping(value = "/saveIngredient", method = RequestMethod.POST)
  public ModelAndView saveIngredient(Ingredients ingredients) {
    ModelAndView model = null;
    boolean saved = ingredients.addIngredient(iDao);
    if (saved) {
      model = new ModelAndView("ingredients/savedIngredient");
    } else {
      model = new ModelAndView("error");
    }
    return model;
  }
}
