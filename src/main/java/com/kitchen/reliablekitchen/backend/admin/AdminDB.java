package com.kitchen.reliablekitchen.backend.admin;

import com.kitchen.reliablekitchen.database.DatabaseConnection;

import java.sql.*;

public class AdminDB implements IAuthentication{
    private IState state;
    Connection connection = DatabaseConnection.getInstance().getConnection();
    public IState login(String username, String password)
    {
        try {
            String sql="select username,password from admin where username=?";
            PreparedStatement statement
                    = connection.prepareStatement(sql);
            statement.setString(1,username);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                if (password.equals(rs.getString("password"))) {
                    state=new Success();
                    return state;
                } else {
                    state= new IncorrectPassword();
                }
            }
            state=new IncorrectUsername();
        } catch (Exception e) {
            e.printStackTrace();
            state=new Failure();
            return state;
        }
        return state;
    }
}
