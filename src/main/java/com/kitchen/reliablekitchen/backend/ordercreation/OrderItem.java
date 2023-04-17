package com.kitchen.reliablekitchen.backend.ordercreation;
import com.kitchen.reliablekitchen.backend.menuitem.MenuItem;

public class OrderItem implements IOrderItem
{
    private MenuItem item;
    private int quantity;
    public OrderItem()
    {
        item=new MenuItem();
    }
    public void makeOrder(String itemName, int quantity)
    {
        if (itemName.equals("") || quantity == 0)
        {
            return;
        }
        this.item.setName(itemName);
        this.quantity = quantity;
    }
    public MenuItem getItem()
    {
        return this.item;
    }
    public void setItem(String itemName)
    {
        if (itemName.equals(""))
        {
            return;
        }
        this.item.setName(itemName);
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
}
