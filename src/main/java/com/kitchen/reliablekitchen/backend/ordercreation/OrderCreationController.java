package com.kitchen.reliablekitchen.backend.ordercreation;
import com.kitchen.reliablekitchen.backend.ingredients.IngredientDAO;
import com.kitchen.reliablekitchen.backend.ingredients.IngredientsDatabase;
import com.kitchen.reliablekitchen.backend.menuitem.MenuItemDatabase;
import com.kitchen.reliablekitchen.backend.menuitem.MenuItemIngredientDatabase;
import com.kitchen.reliablekitchen.backend.kitchenfactory.Kitchen;
import com.kitchen.reliablekitchen.backend.menuitem.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class OrderCreationController
{
    IMenuItem menuItem = Kitchen.Instance().kitchenFactory.MakeMenuItem();

    IOrderItem orderItem=Kitchen.Instance().kitchenFactory.MakeOrderItem();
    IOrder order = null;
    MenuItemDatabase menuItemDatabase = new MenuItemDatabase();

    MenuItemIngredientDAO menuItemIngredientDatabase=new MenuItemIngredientDatabase();

    IngredientDAO ingredientDatabase=new IngredientsDatabase();

    OrderDAO orderDB = new OrderDatabase();
    IOrderMenuItemMapping orderMap= new OrderMenuItemMapping();
    OrderMenuItemMappingDAO orderMapDB= new OrderMenuItemMappingDatabase();
    @RequestMapping("/selecttocart")
    public ModelAndView selectFoodBeverage()
    {
        ModelAndView model = new ModelAndView("feedorder/AllFoodList");
        model.addObject("foodbeverageList", menuItem.getAllFoodBeverage(menuItemDatabase));
        return model;
    }
    @RequestMapping("/addfoodtocart")
    public ModelAndView addFoodToCart(String food1, int quantity1, String food2, int quantity2)
    {
        order=Kitchen.Instance().kitchenFactory.Makeorder();
        ModelAndView modelAndView=null;
        orderItem.makeOrder(food1, quantity1);
        order.addToList(orderItem);
        orderItem = Kitchen.Instance().kitchenFactory.MakeOrderItem();
        orderItem.makeOrder(food2, quantity2);
        order.addToList(orderItem);

        boolean result=order.createOrder(orderDB,orderMap,orderMapDB,menuItem,menuItemDatabase,menuItemIngredientDatabase,ingredientDatabase);
        if (result)
        {
            modelAndView = new ModelAndView("feedorder/OrderSubmit");
        }
        else
        {
            modelAndView = new ModelAndView("feedorder/OrderNotSubmit");

        }
        return modelAndView;
    }
    @RequestMapping("/OrderSubmit")
    public ModelAndView OrderSubmit()
    {
        ModelAndView modelAndView = new ModelAndView("feedorder/OrderSubmit");
        return modelAndView;
    }

    @RequestMapping("/processingorder")
    public ModelAndView processingOrder()
    {
        ModelAndView modelAndView = new ModelAndView();
        if (order.checkStatus().equals("declined")) {
            modelAndView = new ModelAndView("feedorder/OrderNotAccepted");
        } else {
            modelAndView = new ModelAndView("feedorder/OrderAccepted");
        }
        return modelAndView;
    }

}
