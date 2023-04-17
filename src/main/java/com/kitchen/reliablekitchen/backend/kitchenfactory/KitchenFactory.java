package com.kitchen.reliablekitchen.backend.kitchenfactory;

import com.kitchen.reliablekitchen.backend.admin.Admin;
import com.kitchen.reliablekitchen.backend.admin.IAdmin;
import com.kitchen.reliablekitchen.backend.ingredients.IIngredients;
import com.kitchen.reliablekitchen.backend.ingredients.Ingredients;
import com.kitchen.reliablekitchen.backend.events.IObserver;
import com.kitchen.reliablekitchen.backend.menuitem.IMenuItem;
import com.kitchen.reliablekitchen.backend.menuitem.MenuItem;
import com.kitchen.reliablekitchen.backend.menuitem.MenuItemIngredient;
import com.kitchen.reliablekitchen.backend.ordercreation.IOrder;
import com.kitchen.reliablekitchen.backend.ordercreation.IOrderItem;
import com.kitchen.reliablekitchen.backend.ordercreation.Order;
import com.kitchen.reliablekitchen.backend.ordercreation.OrderItem;
import com.kitchen.reliablekitchen.backend.ordercreation.OrderMenuItemMapping;
import com.kitchen.reliablekitchen.backend.orderprocessing.OrderProcessing;
import com.kitchen.reliablekitchen.backend.shortfall.IShortfallOrder;
import com.kitchen.reliablekitchen.backend.shortfall.IShortfallOrderItem;
import com.kitchen.reliablekitchen.backend.shortfall.ShortfallOrder;
import com.kitchen.reliablekitchen.backend.shortfall.ShortfallOrderItem;

public class KitchenFactory implements IKitchenFactory{

    public IAdmin MakeAdmin()
    {
        return new Admin();
    };

    public IMenuItem MakeMenuItem()
    {
        return new MenuItem();
    };

    public MenuItemIngredient MakeMenuItemIngredient()
    {
        return new MenuItemIngredient();
    };

    public IOrder Makeorder()
    {
        return new Order();
    };

    public IOrderItem MakeOrderItem()
    {
       return new OrderItem();
    };

    public OrderMenuItemMapping MakeOrderMenuItemMapping()
    {
        return new OrderMenuItemMapping();

    };

    public IObserver MakeOrderProcessing()
    {
        return new OrderProcessing();
    };

    public IIngredients MakeIngredient()
    {
        return new Ingredients();
    };

    public IShortfallOrder MakeShortFallOrder()
    {
        return new ShortfallOrder();
    };

    public IShortfallOrderItem MakeShortFallOrderItem()
    {
        return new ShortfallOrderItem();
    };

}
