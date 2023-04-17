package com.kitchen.reliablekitchen.backend.admin;

public class Success implements IState{

    private boolean state=true;

    public boolean isLoggedIN()
    {
        return state;
    }

}
