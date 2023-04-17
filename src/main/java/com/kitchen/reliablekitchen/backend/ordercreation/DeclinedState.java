package com.kitchen.reliablekitchen.backend.ordercreation;

public class DeclinedState implements IState
{
    String currentStatus;

    public DeclinedState()
    {
        this.changeCurrentStatus();
    }
    @Override
    public void changeCurrentStatus()
    {
        this.currentStatus = "declined";
    }
    public String getStatus()
    {
        return this.currentStatus;
    }
}
