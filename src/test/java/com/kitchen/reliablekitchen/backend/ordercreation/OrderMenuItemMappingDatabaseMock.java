package com.kitchen.reliablekitchen.backend.ordercreation;

import java.util.ArrayList;

public class OrderMenuItemMappingDatabaseMock implements OrderMenuItemMappingDAO{

    private ArrayList<OrderMenuItemMapping> orderMenuItemMappings;

    public OrderMenuItemMappingDatabaseMock()
    {
        orderMenuItemMappings = new ArrayList<OrderMenuItemMapping>();
        OrderMenuItemMapping m1 = new OrderMenuItemMapping("O1", "F1",5);
        OrderMenuItemMapping m2 = new OrderMenuItemMapping("O2", "F1",4);
        OrderMenuItemMapping m3 = new OrderMenuItemMapping("O3", "F1",9);
        OrderMenuItemMapping m4 = new OrderMenuItemMapping("O4", "F1",7);
        OrderMenuItemMapping m5 = new OrderMenuItemMapping("O5", "F1",2);
        OrderMenuItemMapping m6 = new OrderMenuItemMapping("O6", "F1",1);
        orderMenuItemMappings.add(m1);
        orderMenuItemMappings.add(m2);
        orderMenuItemMappings.add(m3);
        orderMenuItemMappings.add(m4);
        orderMenuItemMappings.add(m5);
        orderMenuItemMappings.add(m6);
    }

    public boolean insertOrderMenuItemMap(IOrderMenuItemMapping orderMenuItemMapping)
    {


        return true;
    }

}
