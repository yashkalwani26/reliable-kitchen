package com.kitchen.reliablekitchen.backend.admin;

public interface IAuthentication {

    public IState state = null;

    public enum Result
    {
        SUCCESS,
        INCORRECT_PASSWORD,

        FAILURE
    }

    public IState login(String username,String password);


}
