package com.kitchen.reliablekitchen.backend.ordercreation;
import java.util.*;

import com.kitchen.reliablekitchen.backend.ingredients.IngredientDAO;
import com.kitchen.reliablekitchen.backend.menuitem.IMenuItem;

import com.kitchen.reliablekitchen.backend.events.EventManager;
import com.kitchen.reliablekitchen.backend.events.IObserver;
import com.kitchen.reliablekitchen.backend.kitchenfactory.Kitchen;
import com.kitchen.reliablekitchen.backend.menuitem.*;
public class Order implements IOrder {
    private String orderID;
    private ArrayList<IOrderItem> menuItemList = new ArrayList<IOrderItem>();
    private IState currentStatus;
    private final IObserver orderProcessing= Kitchen.Instance().kitchenFactory.MakeOrderProcessing();
    private final EventManager manager=new EventManager();
    public Order()
    {
        currentStatus = new PendingState();
        this.orderID= String.valueOf(UUID.randomUUID());
    }
    public Order(String orderID, IState currentStatus)
    {
        this.orderID = orderID;
        this.currentStatus = currentStatus;
    }

    public String getOrderID()
    {
        return orderID;
    }

    public void setOrderID(String orderID)
    {
        if (orderID.equals(""))
        {
            return;
        }
        this.orderID = orderID;
    }

    public void addToList(IOrderItem order)
    {
        if (order.getQuantity() == 0)
        {
            return;
        }
        this.menuItemList.add(order);
    }

    public List<IOrderItem> getOrderList()
    {
        return menuItemList;
    }

    public void setOrderList(ArrayList<IOrderItem> orderList)
    {
        if (orderList.isEmpty())
        {
            return;
        }
        this.menuItemList = orderList;
    }

    public IState getCurrentStatus()
    {
        return currentStatus;
    }

    public void setCurrentStatus(IState currentStatus)
    {
        if (currentStatus == null)
        {
            return;
        }
        this.currentStatus = currentStatus;
    }

    public boolean checkOrderItem(IMenuItem foodbeverage, MenuItemDAO foodbeverageDatabase)
    {
        List<IMenuItem> matchList = foodbeverage.getAllFoodBeverage(foodbeverageDatabase);
        for (int i = 0; i < this.getOrderList().size(); i++)
        {
            int k=0;
            for (IMenuItem iMenuItem : matchList) {
                if (getOrderList().get(i).getItem().getName().equalsIgnoreCase(iMenuItem.getName())) {
                    k = 1;
                    break;
                }
            }
            if(k==0)
            {
                return false;
            }
            k=0;
        }
        return true;
    }
    public boolean insertOrderList(OrderDAO iFeedOrder)
    {
        return iFeedOrder.insertOrderList(this);
    }


    public boolean updateStatusToAccepted(OrderDAO iFeedOrder)
    {
        this.currentStatus = new AcceptedState();
        return iFeedOrder.updateStatus(this);
    }

    public boolean updateStatusToDeclined(OrderDAO iFeedOrder)
    {
        this.currentStatus = new DeclinedState();
        boolean result = iFeedOrder.updateStatus(this);
        return result;
    }
    public boolean createOrder(OrderDAO orderDB, IOrderMenuItemMapping orderMap, OrderMenuItemMappingDAO orderMapDB, IMenuItem menuItem, MenuItemDAO menuItemDatabase, MenuItemIngredientDAO menuItemIngredientDatabase, IngredientDAO ingredientDatabase)
    {
        insertOrderList(orderDB);
        orderMap.setOrderID(getOrderID());
        if(orderMap.insertOrderMenuItemMap(orderMapDB,menuItemDatabase,this))
        {
            manager.subscribe(orderProcessing);
            manager.notifyEvent(this,orderDB,menuItem,menuItemDatabase, menuItemIngredientDatabase,ingredientDatabase);
            manager.unsubscribe(orderProcessing);
            return true;
        }
        else
        {
            return false;
        }
    }
    public String checkStatus()
    {
        return this.currentStatus.getStatus();
    }
}
