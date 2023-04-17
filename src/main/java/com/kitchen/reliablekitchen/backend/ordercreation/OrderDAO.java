package com.kitchen.reliablekitchen.backend.ordercreation;

public interface OrderDAO
{
    public boolean insertOrderList(Order orderList);

    public boolean updateStatus(Order orderList);


}

