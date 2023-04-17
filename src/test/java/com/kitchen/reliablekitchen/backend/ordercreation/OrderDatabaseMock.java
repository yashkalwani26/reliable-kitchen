package com.kitchen.reliablekitchen.backend.ordercreation;

import java.util.ArrayList;

public class OrderDatabaseMock implements OrderDAO {
    ArrayList<Order> orders;
    public OrderDatabaseMock()
    {
        orders = new ArrayList<Order>();
        Order o1 = new Order("I1", new AcceptedState());
        Order o2 = new Order("I2", new AcceptedState());
        Order o3 = new Order("I3", new DeclinedState());
        Order o4 = new Order("I4", new AcceptedState());
        Order o5 = new Order("I5", new AcceptedState());
        orders.add(o1);
        orders.add(o2);
        orders.add(o3);
        orders.add(o4);
        orders.add(o5);
    }

    @Override
    public boolean insertOrderList(Order order)
    {
        orders.add(order);
        for (int i = 0; i < orders.size(); i++)
        {
            if (orders.get(i).getOrderID().equalsIgnoreCase("I6"))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateStatus(Order order)
    {
        for (int i = 0; i < orders.size(); i++)
        {
            if (orders.get(i).getOrderID() == order.getOrderID())
            {
                orders.set(i, order);
                return true;
            }
        }
        return false;
    }
}
