package com.kitchen.reliablekitchen.backend.admin;

public class IncorrectPassword implements IState{

    public boolean isLoggedIN()
    {
        return false;
    }
}
