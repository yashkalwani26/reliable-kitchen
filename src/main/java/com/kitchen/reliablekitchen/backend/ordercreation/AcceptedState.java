package com.kitchen.reliablekitchen.backend.ordercreation;

public class AcceptedState implements IState
{
    String currentStatus;
    public AcceptedState()
    {
        this.changeCurrentStatus();
    }

    @Override
    public void changeCurrentStatus()
    {
        this.currentStatus = "accepted";
    }
    public String getStatus()
    {
        return currentStatus;
    }

}
