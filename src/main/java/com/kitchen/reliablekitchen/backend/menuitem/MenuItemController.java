package com.kitchen.reliablekitchen.backend.menuitem;
import com.kitchen.reliablekitchen.backend.kitchenfactory.Kitchen;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MenuItemController {
    IMenuItem foodbeverage = Kitchen.Instance().kitchenFactory.MakeMenuItem();
    MenuItemDAO foodbeverageDatabase = new MenuItemDatabase();
    IMenuItemIngredient foodbeverageIngredient = Kitchen.Instance().kitchenFactory.MakeMenuItemIngredient();
    MenuItemIngredientDAO foodbeverageIngredientDatabase = new MenuItemIngredientDatabase();

    @RequestMapping("/foodbeverage")
    public ModelAndView allfoodbeverage() {
        ModelAndView model = new ModelAndView("menuitem/AllMenuitemsList");
        model.addObject("foodbeveragelist", foodbeverage.getAllFoodBeverage(foodbeverageDatabase));
        return model;
    }

    @RequestMapping("/add/foodbeverage")
    public ModelAndView addFoodbeverage() {
        ModelAndView model = new ModelAndView("menuitem/addMenuitems");
        return model;
    }

    @RequestMapping(value = "/savefoodbeverage", method = RequestMethod.POST)
    public ModelAndView saveFoodbeverage(MenuItem foodbeverage, @RequestParam("ingredient1") String Ingredient1, @RequestParam("quantity1") String Quantity1, @RequestParam("quantity2") String Quantity2, @RequestParam("ingredient2") String Ingredient2) {

        ArrayList<String> data = new ArrayList<>();
        data.add(Ingredient1);
        data.add(Quantity1);
        data.add(Ingredient2);
        data.add(Quantity2);
        ModelAndView model = null;
        List<String> uid = foodbeverage.saveFoodbeverage(foodbeverage, foodbeverageDatabase);

        if(!uid.get(0).equals("")){
            foodbeverageIngredient.saveFoodbeverageingredient(data, uid.get(0), foodbeverageIngredientDatabase);
            model = new ModelAndView("menuitem/saveMenuitems");
        }else{
            model = new ModelAndView("error");
        }
        return model;
    }
}
