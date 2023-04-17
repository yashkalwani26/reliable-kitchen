package com.kitchen.reliablekitchen.backend.ordercreation;


import com.kitchen.reliablekitchen.backend.menuitem.MenuItemDAO;

public class OrderMenuItemMapping implements IOrderMenuItemMapping {

    private String orderID;
    private String menuItemID;
    private int quantity;

    public String getMenuItemID() {
        return menuItemID;
    }

    public void setMenuItemID(String menuItemID)
    {
        if (menuItemID.equals(""))
        {
            return;
        }
        this.menuItemID = menuItemID;
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

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        if (quantity == 0)
        {
            return;
        }
        this.quantity = quantity;
    }

    public OrderMenuItemMapping()
    {

    }
    public OrderMenuItemMapping(String orderID, String menuItemID, int quantity)
    {
        this.orderID = orderID;
        this.menuItemID = menuItemID;
        this.quantity = quantity;
    }

//    public Boolean insert()
//    {
//        OrderMenuItemMappingDatabase o=new OrderMenuItemMappingDatabase();
//        return o.insert(this);
//    }

    public boolean insertOrderMenuItemMap(OrderMenuItemMappingDAO orderMenuItemMappingDatabase, MenuItemDAO foodbeverageDatabase, IOrder order)
    {
        for(int i=0;i<order.getOrderList().size(); i++)
        {
            String foodBeverageName = order.getOrderList().get(i).getItem().getName();
            this.quantity = order.getOrderList().get(i).getQuantity();
            if(order.getOrderList().get(i).getItem().getFoodBeverageID(foodBeverageName,foodbeverageDatabase).size()>0)
            {
                this.menuItemID = order.getOrderList().get(i).getItem().getFoodBeverageID(foodBeverageName,foodbeverageDatabase).get(0);
            }
            else {
                return false;
            }
             this.orderID=order.getOrderID();
            if(orderMenuItemMappingDatabase.insertOrderMenuItemMap(this))
            {

            }
            else
            {
                return false;
            }
        }
        return true;
    }

}
