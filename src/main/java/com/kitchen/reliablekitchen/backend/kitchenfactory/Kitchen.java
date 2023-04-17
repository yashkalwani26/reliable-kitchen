package com.kitchen.reliablekitchen.backend.kitchenfactory;

public class Kitchen {
    private static Kitchen instance = null;

    public final IKitchenFactory kitchenFactory;

    public static Kitchen Instance()
    {
        if (null == instance)
        {
            instance = new Kitchen();
        }
        return instance;
    }
    private Kitchen()
    {
        kitchenFactory = new KitchenFactory();
    }
}
