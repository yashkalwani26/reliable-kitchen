package com.kitchen.reliablekitchen.backend.kitchenfactory;

import com.kitchen.reliablekitchen.backend.admin.IAdmin;
import com.kitchen.reliablekitchen.backend.events.IObserver;
import com.kitchen.reliablekitchen.backend.menuitem.IMenuItem;
import com.kitchen.reliablekitchen.backend.menuitem.IMenuItemIngredient;
import com.kitchen.reliablekitchen.backend.ingredients.IIngredients;
import com.kitchen.reliablekitchen.backend.ordercreation.*;
import com.kitchen.reliablekitchen.backend.shortfall.IShortfallOrder;
import com.kitchen.reliablekitchen.backend.shortfall.IShortfallOrderItem;

public interface IKitchenFactory {
    public IAdmin MakeAdmin();

    public IMenuItem MakeMenuItem();

    public IMenuItemIngredient MakeMenuItemIngredient();

    public IOrder Makeorder();

    public IOrderItem MakeOrderItem();

    public IOrderMenuItemMapping MakeOrderMenuItemMapping();

    public IObserver MakeOrderProcessing();

    public IIngredients MakeIngredient();

    public IShortfallOrder MakeShortFallOrder();

    public IShortfallOrderItem MakeShortFallOrderItem();

}
