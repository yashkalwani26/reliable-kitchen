package com.kitchen.reliablekitchen.backend.ordercreation;

import com.kitchen.reliablekitchen.backend.ingredients.IngredientsDatabaseMock;
import com.kitchen.reliablekitchen.backend.kitchenfactory.Kitchen;
import com.kitchen.reliablekitchen.backend.menuitem.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class OrderTest {
    @Test
    public void CheckOrderItemFailureTest()
    {
        IOrder order=Kitchen.Instance().kitchenFactory.Makeorder();
        IOrderItem orderItem=Kitchen.Instance().kitchenFactory.MakeOrderItem();
        orderItem.makeOrder("cookie",1);
        order.addToList(orderItem);
        MenuItem foodbeverage=new MenuItem();
        MenuItemDAO foodbeverageDatabase=new MenuItemDatabase();
        boolean result=order.checkOrderItem(foodbeverage,foodbeverageDatabase);
        Assertions.assertEquals(false,result);
    }
    @Test
    public void CheckOrderItemSuccessfulTest()
    {
        IOrder order=Kitchen.Instance().kitchenFactory.Makeorder();
        IOrderItem orderItem=Kitchen.Instance().kitchenFactory.MakeOrderItem();
        orderItem.makeOrder("pizza",1);
        order.addToList(orderItem);
        MenuItem foodBeverage=new MenuItem();
        MenuItemDAO foodBeverageDatabase=new MenuItemDatabase();
        boolean result=order.checkOrderItem(foodBeverage,foodBeverageDatabase);
        Assertions.assertEquals(true,result);
    }
    @Test
    public void InsertOrderListSuccessfulTest()
    {
        OrderDatabaseMock orderDatabaseMock = new OrderDatabaseMock();
        Order order = new Order("I6", new AcceptedState());
        boolean result = order.insertOrderList(orderDatabaseMock);
        Assertions.assertEquals(true, result);
    }
    @Test
    public void InsertOrderListFailureTest()
    {
        OrderDatabaseMock orderDatabaseMock = new OrderDatabaseMock();
        Order order = new Order();
        boolean result = order.insertOrderList(orderDatabaseMock);
        Assertions.assertEquals(false, result);
    }
    @Test
    public void UpdateStatusToAcceptedSuccessfulTest()
    {
        OrderDatabaseMock orderDatabaseMock = new OrderDatabaseMock();
        Order order = new Order("I3", new AcceptedState());
        boolean result = order.updateStatusToAccepted(orderDatabaseMock);
        Assertions.assertEquals(true, result);
    }
    @Test
    public void UpdateStatusToAcceptedFailureTest()
    {
        OrderDatabaseMock orderDatabaseMock = new OrderDatabaseMock();
        Order order = new Order("I7", new AcceptedState());
        boolean result = order.updateStatusToAccepted(orderDatabaseMock);
        Assertions.assertEquals(false, result);
    }
    @Test
    public void UpdateStatusToDeclinedSuccessTest()
    {
        OrderDatabaseMock orderDatabaseMock = new OrderDatabaseMock();
        IOrder order = Kitchen.Instance().kitchenFactory.Makeorder();
        order.setOrderID("I5");
        order.setCurrentStatus(new DeclinedState());
        boolean result = order.updateStatusToDeclined(orderDatabaseMock);
        Assertions.assertEquals(true, result);
    }
    @Test
    public void UpdateStatusToDeclinedFailureTest()
    {
        OrderDatabaseMock orderDatabaseMock = new OrderDatabaseMock();
        IOrder order = Kitchen.Instance().kitchenFactory.Makeorder();
        order.setOrderID("I7");
        order.setCurrentStatus(new DeclinedState());
        boolean result = order.updateStatusToDeclined(orderDatabaseMock);
        Assertions.assertEquals(false, result);
    }
    @Test
    public void createOrderTest()
    {
        IOrder order = Kitchen.Instance().kitchenFactory.Makeorder();

        OrderDatabaseMock orderDatabaseMock = new OrderDatabaseMock();
        IOrderItem orderItem = Kitchen.Instance().kitchenFactory.MakeOrderItem();
        orderItem.setQuantity(5);
        ArrayList<IOrderItem> iOrderItems = new ArrayList<>();
        iOrderItems.add(orderItem);
        order.setOrderList(iOrderItems);
        IOrderMenuItemMapping orderMenuItemMapping = new OrderMenuItemMapping();
        OrderMenuItemMappingDatabaseMock orderMenuItemMappingDatabaseMock = new OrderMenuItemMappingDatabaseMock();
        IMenuItem menuItem = Kitchen.Instance().kitchenFactory.MakeMenuItem();
        MenuItemDBMock menuItemDBMock = new MenuItemDBMock();
        MenuItemIngredientDBMock menuItemIngredientDBMock = new MenuItemIngredientDBMock();
        IngredientsDatabaseMock ingredientsDatabaseMock = new IngredientsDatabaseMock();
        boolean result = order.createOrder(orderDatabaseMock, orderMenuItemMapping, orderMenuItemMappingDatabaseMock, menuItem, menuItemDBMock, menuItemIngredientDBMock, ingredientsDatabaseMock);
        Assertions.assertEquals(true, result);
    }
    @Test
    public void setOrderIDSuccessfulTest()
    {
        IOrder order = Kitchen.Instance().kitchenFactory.Makeorder();
        order.setOrderID("Pasta");
        Assertions.assertEquals("Pasta", order.getOrderID());
    }
    @Test
    public void setOrderIDFailureTest()
    {
        IOrder order = Kitchen.Instance().kitchenFactory.Makeorder();
        order.setOrderID("Pasta");
        order.setOrderID("");
        Assertions.assertEquals("Pasta", order.getOrderID());
    }
    @Test
    public void setOrderListSuccessfulTest()
    {
        IOrder order = Kitchen.Instance().kitchenFactory.Makeorder();
        IOrderItem orderItem = Kitchen.Instance().kitchenFactory.MakeOrderItem();
        orderItem.setQuantity(5);
        ArrayList<IOrderItem> iOrderItems = new ArrayList<>();
        iOrderItems.add(orderItem);
        order.setOrderList(iOrderItems);
        Assertions.assertEquals(5, order.getOrderList().get(0).getQuantity());
    }
    @Test
    public void setOrderListFailureTest()
    {
        IOrder order = Kitchen.Instance().kitchenFactory.Makeorder();
        IOrderItem orderItem = Kitchen.Instance().kitchenFactory.MakeOrderItem();
        orderItem.setQuantity(5);
        ArrayList<IOrderItem> iOrderItems = new ArrayList<>();
        iOrderItems.add(orderItem);
        orderItem.setQuantity(0);
        iOrderItems.set(0, orderItem);
        order.setOrderList(iOrderItems);
        Assertions.assertEquals(5, order.getOrderList().get(0).getQuantity());
    }

    @Test
    public void setCurrentStatusSuccessfulTest()
    {
        IOrder order = Kitchen.Instance().kitchenFactory.Makeorder();
        IState iState = new AcceptedState();
        order.setCurrentStatus(iState);
        Assertions.assertEquals(iState, order.getCurrentStatus());
    }
    @Test
    public void setCurrentStatusFailureTest()
    {
        IOrder order = Kitchen.Instance().kitchenFactory.Makeorder();
        IState iState = new AcceptedState();
        order.setCurrentStatus(iState);
        IState iState1 = null;
        order.setCurrentStatus(iState1);
        Assertions.assertEquals(iState, order.getCurrentStatus());
    }

    @Test
    public void addToListSuccessfulTest()
    {
        IOrder order = Kitchen.Instance().kitchenFactory.Makeorder();
        IOrderItem orderItem = Kitchen.Instance().kitchenFactory.MakeOrderItem();
        orderItem.setQuantity(5);
        order.addToList(orderItem);
        Assertions.assertEquals(5, order.getOrderList().get(0).getQuantity());
    }
    @Test
    public void getOrderIDTest()
    {
        IOrder order = Kitchen.Instance().kitchenFactory.Makeorder();
        order.setOrderID("O1");
        Assertions.assertEquals("O1", order.getOrderID());
    }
    @Test
    public void getOrderListTest()
    {
        IOrder order = Kitchen.Instance().kitchenFactory.Makeorder();
        ArrayList<IOrderItem> orderItems = new ArrayList<>();
        order.setOrderList(orderItems);
        Assertions.assertEquals(orderItems, order.getOrderList());
    }
    @Test
    public void getCurrentStatus()
    {
        IOrder order = Kitchen.Instance().kitchenFactory.Makeorder();
        IState iState = new AcceptedState();
        order.setCurrentStatus(iState);
        Assertions.assertEquals(iState, order.getCurrentStatus());
    }
}
