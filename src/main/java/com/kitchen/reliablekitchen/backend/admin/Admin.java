package com.kitchen.reliablekitchen.backend.admin;

public class Admin implements IAdmin{
    private String username;
    private String password;
    public Admin() {
        this.state = new IncorrectUsername();
    }
    public IState getState() {
        return state;
    }
    public void setState(IState state) {
        this.state = state;
    }
    private IState state;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public IState login(IAuthentication auth)
    {
        this.state=auth.login(getUsername(), getPassword());
        return state;
    }







}
