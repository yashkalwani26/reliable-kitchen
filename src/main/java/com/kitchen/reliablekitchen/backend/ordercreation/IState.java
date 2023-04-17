package com.kitchen.reliablekitchen.backend.ordercreation;

public interface IState
{

    void changeCurrentStatus();
    String getStatus();
}
