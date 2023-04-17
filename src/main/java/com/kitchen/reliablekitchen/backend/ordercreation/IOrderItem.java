package com.kitchen.reliablekitchen.backend.ordercreation;

import com.kitchen.reliablekitchen.backend.menuitem.MenuItem;

public interface IOrderItem {

    public void makeOrder(String itemName,int quantity );
    public MenuItem getItem();
    public void setItem(String itemName);
    public int getQuantity();
    public void setQuantity(int quantity);
}
