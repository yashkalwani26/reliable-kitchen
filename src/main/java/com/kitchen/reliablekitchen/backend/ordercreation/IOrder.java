package com.kitchen.reliablekitchen.backend.ordercreation;

import com.kitchen.reliablekitchen.backend.ingredients.IngredientDAO;
import com.kitchen.reliablekitchen.backend.menuitem.IMenuItem;
import com.kitchen.reliablekitchen.backend.menuitem.MenuItemDAO;
import com.kitchen.reliablekitchen.backend.menuitem.MenuItemIngredientDAO;

import java.util.ArrayList;
import java.util.List;

public interface IOrder
{
    public void addToList(IOrderItem order);
    public boolean checkOrderItem(IMenuItem foodbeverage, MenuItemDAO foodbeverageDatabase);
    public boolean insertOrderList(OrderDAO iFeedOrder);
    public boolean updateStatusToAccepted(OrderDAO iFeedOrder);
    public boolean updateStatusToDeclined(OrderDAO iFeedOrder);
    public String getOrderID();
    public void setOrderID(String orderID);
    public List<IOrderItem> getOrderList();
    public boolean createOrder(OrderDAO orderDB, IOrderMenuItemMapping OrderMap, OrderMenuItemMappingDAO orderMapDB, IMenuItem menuItem, MenuItemDAO menuItemDatabase, MenuItemIngredientDAO menuItemIngredientDatabase, IngredientDAO ingredientDatabase);
    public String checkStatus();
    public void setOrderList(ArrayList<IOrderItem> orderList);
    public void setCurrentStatus(IState currentStatus);
    public IState getCurrentStatus();
}
