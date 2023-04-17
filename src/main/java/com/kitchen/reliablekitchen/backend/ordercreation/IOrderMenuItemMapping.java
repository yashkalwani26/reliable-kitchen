package com.kitchen.reliablekitchen.backend.ordercreation;

import com.kitchen.reliablekitchen.backend.menuitem.MenuItemDAO;

public interface IOrderMenuItemMapping
{
    public String getMenuItemID();
    public void setMenuItemID(String menuItemID);

    public String getOrderID();

    public void setOrderID(String orderID);

    public int getQuantity();

    public void setQuantity(int quantity);
    public boolean insertOrderMenuItemMap(OrderMenuItemMappingDAO orderMenuItemMappingDatabase, MenuItemDAO foodbeverageDatabase, IOrder order);
}
