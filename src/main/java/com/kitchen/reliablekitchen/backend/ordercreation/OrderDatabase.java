package com.kitchen.reliablekitchen.backend.ordercreation;
import com.kitchen.reliablekitchen.backend.menuitem.MenuItem;
import com.kitchen.reliablekitchen.database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class OrderDatabase implements OrderDAO {

    Connection connection = DatabaseConnection.getInstance().getConnection();
    static MenuItem foodbeverage = new MenuItem();

    public OrderDatabase()
    {

    }
    public boolean insertOrderList(Order orderList)
    {
        try
        {     String sql = "INSERT into orders(orderID, status ) values(?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, orderList.getOrderID());
            statement.setString(2, orderList.getCurrentStatus().getStatus());
            statement.executeUpdate();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateStatus(Order orderList)
    {
        try {
            String sql = "UPDATE orders SET status=? WHERE orderID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, orderList.getCurrentStatus().getStatus());
            statement.setString(2,orderList.getOrderID());
            statement.executeUpdate();
        } catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
