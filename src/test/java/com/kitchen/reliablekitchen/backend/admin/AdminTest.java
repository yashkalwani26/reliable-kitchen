package com.kitchen.reliablekitchen.backend.admin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdminTest {

    @Test
    void loginSuccessTest()
    {
        Admin a=new Admin();
        a.setUsername("utsav");
        a.setPassword("Try_again");
        IAuthentication auth=new AdminDBMock();
        IState state=new Success();
        Assertions.assertEquals(state.isLoggedIN(),a.login(auth).isLoggedIN());
    }

    @Test
    void IncorrectUsernameTest()
    {
        Admin a=new Admin();
        a.setUsername("shvet");
        a.setPassword("Try_again");
        IAuthentication auth=new AdminDBMock();
        IState state=new IncorrectUsername();
        Assertions.assertEquals(state.isLoggedIN(),a.login(auth).isLoggedIN());
    }

    @Test
    void IncorrectPasswordTest()
    {
        Admin a=new Admin();
        a.setUsername("utsav");
        a.setPassword("I don't know");
        IAuthentication auth=new AdminDBMock();
        IState state=new IncorrectPassword();
        Assertions.assertEquals(state.isLoggedIN(),a.login(auth).isLoggedIN());
    }
}
