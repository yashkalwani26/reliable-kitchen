package com.kitchen.reliablekitchen.backend.shortfall;

import com.kitchen.reliablekitchen.backend.kitchenfactory.Kitchen;
import com.kitchen.reliablekitchen.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShortfallOrderDatabase implements ShortfallOrderDAO{

  Connection connection = DatabaseConnection.getInstance().getConnection();

  public boolean insertRetailerOrder(IShortfallOrder shortfallOrder) {
    try {
      String sql =
        "INSERT into shortfall_order(retailerOrderId, orderTimestamp) values(?,?)";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, shortfallOrder.getRetailerOrderId());
      statement.setString(2, shortfallOrder.getOrderTimestamp());
      statement.execute();
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public List<IShortfallOrder> findAll() {
    List<IShortfallOrder> shortfallOrders = new ArrayList<IShortfallOrder>();
    try {
      String sql = "SELECT * FROM shortfall_order";
      PreparedStatement statement = connection.prepareStatement(sql);
      ResultSet resultSet = statement.executeQuery();

      shortfallOrders = convertResponse(resultSet);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return shortfallOrders;
  }

  List<IShortfallOrder> convertResponse(ResultSet rs) {
    List<IShortfallOrder> shortfallOrders = new ArrayList<>();
    try {
      while (rs.next()) {
        IShortfallOrder shortfallOrder = Kitchen.Instance().kitchenFactory.MakeShortFallOrder();
        shortfallOrder.setRetailerOrderId(rs.getString("retailerOrderId"));
        shortfallOrder.setOrderTimestamp(rs.getString("orderTimestamp"));
        shortfallOrders.add(shortfallOrder);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return shortfallOrders;
  }
}
