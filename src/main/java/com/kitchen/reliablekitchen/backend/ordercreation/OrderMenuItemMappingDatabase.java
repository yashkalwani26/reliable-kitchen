package com.kitchen.reliablekitchen.backend.ordercreation;
import com.kitchen.reliablekitchen.database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class OrderMenuItemMappingDatabase implements OrderMenuItemMappingDAO {

    Connection connection = DatabaseConnection.getInstance().getConnection();


    public boolean insertOrderMenuItemMap(IOrderMenuItemMapping link) {
        try {
            String sql = "INSERT into order_foodbeverage values(?,?,?)";
            PreparedStatement statement
                    = connection.prepareStatement(sql);
            statement.setString(1, link.getOrderID());
            statement.setString(2, link.getMenuItemID());
            statement.setInt(3, link.getQuantity());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
            return true;
    }


}
