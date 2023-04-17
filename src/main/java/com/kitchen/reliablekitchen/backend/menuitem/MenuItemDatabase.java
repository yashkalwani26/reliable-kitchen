package com.kitchen.reliablekitchen.backend.menuitem;
import com.kitchen.reliablekitchen.backend.kitchenfactory.Kitchen;
import com.kitchen.reliablekitchen.database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MenuItemDatabase implements MenuItemDAO {

  Connection connection = DatabaseConnection.getInstance().getConnection();

  @Override
  public List<IMenuItem> findAll(MenuItemDAO iFoodbeverageDatabase) {
    List<IMenuItem> foodlist = new ArrayList<IMenuItem>();
    try {
      String sql = "SELECT * FROM foodbeverage";
      PreparedStatement statement = connection.prepareStatement(sql);
      ResultSet resultSet = statement.executeQuery();

      foodlist = convertResponse(resultSet);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return foodlist;
  }

  public List<IMenuItem> convertResponse(ResultSet rs) {
    List<IMenuItem> foodlist = new ArrayList<IMenuItem>();
    try {
      while (rs.next()) {
        IMenuItem foodbeverage = Kitchen
          .Instance()
          .kitchenFactory.MakeMenuItem();
        foodbeverage.setName(rs.getString("name"));
        foodlist.add(foodbeverage);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return foodlist;
  }

  @Override
  public List<String> insert(IMenuItem foodbeverage, MenuItemDAO iFoodbeverageDatabase) {
    List<String> foodlist = new ArrayList<>();
    String uid = UUID.randomUUID().toString();
    try {
      String sql =
        "insert into foodbeverage(id, name, price) values(?,?,?)";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, uid);
      statement.setString(2, foodbeverage.getName());
      statement.setString(3, foodbeverage.getPrice());
      statement.execute();
    } catch (Exception e) {
      e.printStackTrace();
      foodlist.add("");
      return foodlist;
    }

    foodlist.add(uid);
    return foodlist;
  }

  @Override
  public List<String> getFoodBeverageID(String name, MenuItemDAO iFoodbeverageDatabase) {
      List<String> stringid = new ArrayList<>();
      String id = null;
      try {
          String sql = "select id from foodbeverage where name =?";
          PreparedStatement statement = connection.prepareStatement(sql);
          statement.setString(1, name);
          ResultSet rs = statement.executeQuery();
          while (rs.next()) {
              id = rs.getString("id");
              stringid.add(id);
          }
      } catch (Exception e) {
          e.printStackTrace();
      }
      return stringid;
  }
}
