package com.kitchen.reliablekitchen.backend.ordercreation;
import com.kitchen.reliablekitchen.backend.kitchenfactory.Kitchen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderItemTest
{
    @Test
    public void setItemSuccessfulTest()
    {
        IOrderItem orderItem= Kitchen.Instance().kitchenFactory.MakeOrderItem();
        orderItem.setItem("Pasta");
        Assertions.assertEquals("Pasta", orderItem.getItem().getName());
    }
    @Test
    public void setItemFailureTest()
    {
        IOrderItem orderItem= Kitchen.Instance().kitchenFactory.MakeOrderItem();
        orderItem.setItem("Pasta");
        orderItem.setItem("");
        Assertions.assertEquals("Pasta", orderItem.getItem().getName());
    }
    @Test
    public void setQuantitySuccessfulTest()
    {
        IOrderItem orderItem= Kitchen.Instance().kitchenFactory.MakeOrderItem();
        orderItem.setQuantity(5);
        Assertions.assertEquals(5, orderItem.getQuantity());
    }
    @Test
    public void setQuantityFailureTest()
    {
        IOrderItem orderItem= Kitchen.Instance().kitchenFactory.MakeOrderItem();
        orderItem.setQuantity(5);
        orderItem.setQuantity(0);
        Assertions.assertEquals(5, orderItem.getQuantity());
    }
    @Test
    public void makeOrderSuccessfulTest()
    {
        IOrderItem orderItem= Kitchen.Instance().kitchenFactory.MakeOrderItem();
        orderItem.makeOrder("Pasta", 5);
        Assertions.assertEquals("Pasta", orderItem.getItem().getName());
    }
    @Test
    public void makeOrderFailureTest()
    {
        IOrderItem orderItem= Kitchen.Instance().kitchenFactory.MakeOrderItem();
        orderItem.makeOrder("Pasta", 5);
        orderItem.makeOrder("",10);
        Assertions.assertEquals("Pasta", orderItem.getItem().getName());
    }
    @Test
    public void getItemTest()
    {
        IOrderItem orderItem= Kitchen.Instance().kitchenFactory.MakeOrderItem();
        orderItem.setItem("Pizza");
        Assertions.assertEquals("Pizza", orderItem.getItem().getName());
    }
    @Test
    public void getQuantity()
    {
        IOrderItem orderItem= Kitchen.Instance().kitchenFactory.MakeOrderItem();
        orderItem.setQuantity(25);;
        Assertions.assertEquals(25, orderItem.getQuantity());
    }
}
