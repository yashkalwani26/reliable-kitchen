package com.kitchen.reliablekitchen.backend.admin;



public class AdminDBMock implements IAuthentication {
    private String uname="utsav";

    private  String passWord="Try_again";

    private IState state=null;

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public IState login(String username,String password)
    {
        if(username.equals(uname))
        {
            if(password.equals(passWord))
            {
                state=new Success();
                return state;
            }
            else {
                state=new IncorrectPassword();
                return state;
            }
        }
        else {
            state=new IncorrectUsername();
            return state;
        }
    }
}
