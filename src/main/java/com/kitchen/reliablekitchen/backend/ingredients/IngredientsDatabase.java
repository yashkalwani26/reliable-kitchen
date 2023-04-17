package com.kitchen.reliablekitchen.backend.ingredients;

import com.kitchen.reliablekitchen.backend.kitchenfactory.Kitchen;
import com.kitchen.reliablekitchen.database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class IngredientsDatabase implements IngredientDAO {

  Connection connection = DatabaseConnection.getInstance().getConnection();


  public List<IIngredients> findName(String ingredientID) throws Exception{
    List<IIngredients> nameList = new ArrayList<IIngredients>();
    try {
      String sql = "SELECT * FROM ingredients WHERE id = ?";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, ingredientID);
      ResultSet resultSet = statement.executeQuery();

      nameList = convertResponse(resultSet);
    } catch (Exception e) {
      throw e;
    }
    return nameList;
  }

  public List<IIngredients> findAll() throws Exception {
    List<IIngredients> ingredientsList = new ArrayList<IIngredients>();
    try {
      String sql = "SELECT * FROM ingredients";
      PreparedStatement statement = connection.prepareStatement(sql);
      ResultSet resultSet = statement.executeQuery();
      ingredientsList = convertResponse(resultSet);
    } catch (Exception e) {
      throw e;
    }
    return ingredientsList;
  }


  public List<IIngredients> findLesserThanThreshold() throws Exception {
    List<IIngredients> ingredientsList = new ArrayList<IIngredients>();

    try {
      String sql =
        "SELECT * FROM ingredients WHERE availableQuantity <= thresholdQuantity";
      PreparedStatement statement = connection.prepareStatement(sql);
      ResultSet resultSet = statement.executeQuery();
      ingredientsList = convertResponse(resultSet);
    } catch (Exception e) {
      throw e;
    }
    return ingredientsList;
  }

  public List<IIngredients> findById(String id) {
    List<IIngredients> ingredientsList = new ArrayList<IIngredients>();
    try {
      String sql = "SELECT * FROM ingredients WHERE id = ?";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, id);
      ResultSet resultSet = statement.executeQuery();
      ingredientsList = convertResponse(resultSet);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return ingredientsList;
  }

  public boolean insert(Ingredients ingredient) {
    try {

      String sql =
        "INSERT into ingredients(id, name, availableQuantity, thresholdQuantity) values(?,?,?,?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, ingredient.getId());
        statement.setString(2, ingredient.getName());
        statement.setInt(3, ingredient.getAvailableQuantity());
        statement.setInt(4, ingredient.getThresholdQuantity());
      statement.execute();
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public boolean updateIngredient(Ingredients ingredients) {
    try {
      String sql =
        "UPDATE ingredients SET name =?, availableQuantity =? thresholdQuantity = ? WHERE id = ?";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, ingredients.getId());
      statement.setInt(2, ingredients.getAvailableQuantity());
      statement.setInt(3, ingredients.getThresholdQuantity());
      statement.setString(4, ingredients.getId());
      statement.execute();
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public boolean updateAvailableQuantity(Ingredients ingredient) {
    try {
      String sql = "UPDATE ingredients SET availableQuantity = ? where id = ?";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setInt(1, ingredient.getAvailableQuantity());
      statement.setString(2, ingredient.getId());
      statement.execute();
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public List<IIngredients> convertResponse(ResultSet rs) {
    List<IIngredients> ingredientsList = new ArrayList<>();
    try {
      while (rs.next()) {
        IIngredients ingredients = Kitchen.Instance().kitchenFactory.MakeIngredient();
        ingredients.setName(rs.getString("name"));
        ingredients.setAvailableQuantity(rs.getInt("availableQuantity"));
        ingredients.setThresholdQuantity(rs.getInt("thresholdQuantity"));
        ingredientsList.add(ingredients);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return ingredientsList;
  }

  public String getIngredientId(String ingredientName) throws SQLException {
    String sql = "select id from ingredients where name = ?";
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, ingredientName);
    ResultSet rs = statement.executeQuery();
    String id = "";
    if(rs.next()) {
      id = rs.getString("id");
    }
    return id;
  }

  public String getIngredientName(String ingredientid) throws SQLException {

    String sql =
      "select id from ingredients where id = ?";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, ingredientid);
    ResultSet rs = statement.executeQuery();
    String ingredientName = "";
    while (rs.next()) {
      ingredientName = rs.getString("name");
    }
    return ingredientName;
  }
}
