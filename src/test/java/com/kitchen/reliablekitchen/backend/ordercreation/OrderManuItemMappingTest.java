package com.kitchen.reliablekitchen.backend.ordercreation;

import com.kitchen.reliablekitchen.backend.kitchenfactory.Kitchen;
import com.kitchen.reliablekitchen.backend.menuitem.MenuItemDAO;
import com.kitchen.reliablekitchen.backend.menuitem.MenuItemDBMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderManuItemMappingTest {
    @Test
    public void successinsertOrderMenuItemMap()
    {
        IOrderMenuItemMapping orderMenuItemMapping= Kitchen.Instance().kitchenFactory.MakeOrderMenuItemMapping();
        OrderMenuItemMappingDAO orderMenuItemMappingDatabase=new OrderMenuItemMappingDatabaseMock();
        MenuItemDAO menuItemDatabase=new MenuItemDBMock();
        IOrder order=Kitchen.Instance().kitchenFactory.Makeorder();
        IOrderItem orderItem=Kitchen.Instance().kitchenFactory.MakeOrderItem();
        orderItem.makeOrder("pizza",1);
        order.addToList(orderItem);
        boolean result=orderMenuItemMapping.insertOrderMenuItemMap(orderMenuItemMappingDatabase,menuItemDatabase,order);
        Assertions.assertEquals(true,result);
    }
    @Test
    public void setMenuItemIDSuccessfulTest()
    {
        IOrderMenuItemMapping orderMenuItemMapping= Kitchen.Instance().kitchenFactory.MakeOrderMenuItemMapping();
        orderMenuItemMapping.setMenuItemID("M1");
        Assertions.assertEquals("M1", orderMenuItemMapping.getMenuItemID());
    }
    @Test
    public void setMenuItemIDFailureTest()
    {
        IOrderMenuItemMapping orderMenuItemMapping= Kitchen.Instance().kitchenFactory.MakeOrderMenuItemMapping();
        orderMenuItemMapping.setMenuItemID("M1");
        orderMenuItemMapping.setMenuItemID("");
        Assertions.assertEquals("M1", orderMenuItemMapping.getMenuItemID());
    }

    @Test
    public void setOrderIDSuccessfulTest()
    {
        IOrderMenuItemMapping orderMenuItemMapping= Kitchen.Instance().kitchenFactory.MakeOrderMenuItemMapping();
        orderMenuItemMapping.setOrderID("O1");
        Assertions.assertEquals("O1", orderMenuItemMapping.getOrderID());
    }
    @Test
    public void setOrderIDFailureTest()
    {
        IOrderMenuItemMapping orderMenuItemMapping= Kitchen.Instance().kitchenFactory.MakeOrderMenuItemMapping();
        orderMenuItemMapping.setOrderID("O1");
        orderMenuItemMapping.setOrderID("");
        Assertions.assertEquals("O1", orderMenuItemMapping.getOrderID());
    }
    @Test
    public void setQuantitySuccessTest()
    {
        IOrderMenuItemMapping orderMenuItemMapping= Kitchen.Instance().kitchenFactory.MakeOrderMenuItemMapping();
        orderMenuItemMapping.setQuantity(8);
        Assertions.assertEquals(8, orderMenuItemMapping.getQuantity());
    }
    @Test
    public void setQuantityFailureTest()
    {
        IOrderMenuItemMapping orderMenuItemMapping= Kitchen.Instance().kitchenFactory.MakeOrderMenuItemMapping();
        orderMenuItemMapping.setQuantity(8);
        orderMenuItemMapping.setQuantity(0);
        Assertions.assertEquals(8, orderMenuItemMapping.getQuantity());
    }
    @Test
    public void getOrderIDTest()
    {
        IOrderMenuItemMapping orderMenuItemMapping= Kitchen.Instance().kitchenFactory.MakeOrderMenuItemMapping();
        orderMenuItemMapping.setOrderID("OM1");
        Assertions.assertEquals("OM1", orderMenuItemMapping.getOrderID());
    }
    @Test
    public void getQuantityTest()
    {
        IOrderMenuItemMapping orderMenuItemMapping= Kitchen.Instance().kitchenFactory.MakeOrderMenuItemMapping();
        orderMenuItemMapping.setQuantity(7);
        Assertions.assertEquals(7, orderMenuItemMapping.getQuantity());
    }
    @Test
    public void getMenuID()
    {
        IOrderMenuItemMapping orderMenuItemMapping= Kitchen.Instance().kitchenFactory.MakeOrderMenuItemMapping();
        orderMenuItemMapping.setMenuItemID("M1");
        Assertions.assertEquals("M1", orderMenuItemMapping.getMenuItemID());
    }
}
