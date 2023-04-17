package com.kitchen.reliablekitchen.backend.ordercreation;

public class PendingState implements IState
{
    String currentStatus;
    public PendingState()
    {
        this.changeCurrentStatus();
    }

    public String getStatus()
    {
        return currentStatus;
    }

    @Override
    public void changeCurrentStatus()
    {
        this.currentStatus = "pending";
    }
}
