package com.kitchen.reliablekitchen.backend.shortfall;

import com.kitchen.reliablekitchen.backend.kitchenfactory.Kitchen;
import com.kitchen.reliablekitchen.database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShortfallOrderItemDatabase implements ShortfallOrderItemDAO {

  Connection connection = DatabaseConnection.getInstance().getConnection();

  public boolean insertRetailerOrderList(
    IShortfallOrderItem shortfallOrderItem
  ) {
    try {
      String sql =
        "INSERT into shortfall_order_list(retailerOrderId, ingredientId, shortfallQuantity, ingredientName) values(?,?,?,?)";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, shortfallOrderItem.getRetailerOrderId());
      statement.setString(2, shortfallOrderItem.getIngredientId());
      statement.setInt(3, shortfallOrderItem.getShortfallQuantity());
      statement.setString(4, shortfallOrderItem.getIngredientName());
      statement.execute();
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public List<IShortfallOrderItem> findAllById(
    IShortfallOrderItem shortfallOrderItem
  ) {
    List<IShortfallOrderItem> shortfallOrdersList = new ArrayList<IShortfallOrderItem>();
    try {
      String sql =
        "SELECT * FROM shortfall_order_list where retailerOrderId = ?";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, shortfallOrderItem.getRetailerOrderId());
      ResultSet resultSet = statement.executeQuery();
      shortfallOrdersList = convertResponse(resultSet);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return shortfallOrdersList;
  }

  List<IShortfallOrderItem> convertResponse(ResultSet rs) {
    List<IShortfallOrderItem> shortfallOrderLists = new ArrayList<>();
    try {
      while (rs.next()) {
        IShortfallOrderItem shortfallOrderItem = Kitchen
          .Instance()
          .kitchenFactory.MakeShortFallOrderItem();
        shortfallOrderItem.setRetailerOrderId(rs.getString("retailerOrderId"));
        shortfallOrderItem.setIngredientId(rs.getString("ingredientId"));
        shortfallOrderItem.setShortfallQuantity(rs.getInt("shortfallQuantity"));
        shortfallOrderItem.setIngredientName(rs.getString("ingredientName"));
        shortfallOrderLists.add(shortfallOrderItem);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return shortfallOrderLists;
  }
}
