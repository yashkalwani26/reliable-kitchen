package com.kitchen.reliablekitchen.backend.menuitem;

import com.kitchen.reliablekitchen.backend.ingredients.IIngredients;
import com.kitchen.reliablekitchen.backend.ingredients.IngredientsDatabase;
import com.kitchen.reliablekitchen.backend.kitchenfactory.Kitchen;
import com.kitchen.reliablekitchen.database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuItemIngredientDatabase implements MenuItemIngredientDAO {

    Connection connection = DatabaseConnection.getInstance().getConnection();
    IngredientsDatabase ingredientsDatabase = new IngredientsDatabase();

    @Override
    public List<Boolean> insert(ArrayList<String> foodBeverageingredient, String uid, MenuItemIngredientDAO iFoodbeverageIngredientDatabase){
        List<Boolean> result = new ArrayList<>();
        int i=0;
        while(i<foodBeverageingredient.size()-1){
            try {
                String sql = "insert into foodbeverage_ingredients(ingredients_id, foodbeverage_id, requiredQuantity) values(?,?,?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, ingredientsDatabase.getIngredientId(foodBeverageingredient.get(i)));
                statement.setString(2, uid);
                statement.setString(3, foodBeverageingredient.get(i+1));
                statement.executeUpdate();
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
            i = i + 2;
        }
        result.add(true);
        return result;
    }

    @Override
    public List<IIngredients> fetch(String foodBeverageid, MenuItemIngredientDAO iFoodbeverageIngredientDatabase){
        List<IIngredients> ingredients = new ArrayList<IIngredients>();
        try {
            String sql = "select * from foodbeverage_ingredients where foodbeverage_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, foodBeverageid);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                ingredients = ingredientsDatabase.findById(rs.getString("id"));
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ingredients;
    }


    @Override
    public HashMap<String, Integer> findNameStringQuantity(String foodBeverageid, MenuItemIngredientDAO iFoodbeverageIngredientDatabase) {
        return null;
    }

    @Override
    public HashMap<IIngredients, Integer> fetchNameQuantity(String foodBeverageid, MenuItemIngredientDAO iFoodbeverageIngredientDatabase)
    {
        HashMap<IIngredients, Integer> r = new HashMap<IIngredients, Integer>();
        HashMap<String, Integer> rIngredients = new HashMap<String , Integer >();
        try {
            String sql = "select * from foodbeverage_ingredients where foodbeverage_id= ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, foodBeverageid);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                String ingredientID = rs.getString("ingredients_id");
                int requiredQuantity = rs.getInt("requiredQuantity");
                rIngredients.put(ingredientID,requiredQuantity);
                IIngredients ingredients = Kitchen.Instance().kitchenFactory.MakeIngredient();
                ingredients.setId(ingredientID);
                r.put(ingredients, requiredQuantity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return r;
    }

}
