package com.kitchen.reliablekitchen.backend.menuitem;

import com.kitchen.reliablekitchen.backend.ingredients.IIngredients;
import com.kitchen.reliablekitchen.backend.kitchenfactory.Kitchen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MenuItemIngredientDBMock implements MenuItemIngredientDAO {
    List<List<String>> foodIngredient = new ArrayList<>();

    public MenuItemIngredientDBMock(){
        addFoodIngredient();
    }
    @Override
    public List<Boolean> insert(ArrayList<String> foodbeverageingredient, String uid, MenuItemIngredientDAO iFoodbeverageIngredientDatabase) {
        List<Boolean> result = new ArrayList<>();
        List<String> sublist = new ArrayList<>();

        if(foodbeverageingredient.isEmpty() || uid.equals("")){
            result.add(false);
            return result;
        }
        else{
            sublist.add(foodbeverageingredient.get(0));
            sublist.add(uid);
            sublist.add(foodbeverageingredient.get(1));

            List<List<String>> newFoodIngredient = new ArrayList<>(foodIngredient);
            newFoodIngredient.add(sublist);
        }
        result.add(true);
        return result;
    }

    @Override
    public List<IIngredients> fetch(String foodBeverageid, MenuItemIngredientDAO iFoodbeverageIngredientDatabase) {
        List<IIngredients> result = new ArrayList<>();
        IIngredients ingredients = Kitchen.Instance().kitchenFactory.MakeIngredient();
        for(List<String> list : foodIngredient){
            if(list.get(1).equals(foodBeverageid)){
                ingredients.setId(list.get(0));
                result.add(ingredients);
            }
        }

        if(result.isEmpty()){
            ingredients.setId("0");
            result.add(ingredients);
        }
        return result;
    }

    @Override
    public HashMap<String, Integer> findNameStringQuantity(String foodBeverageid, MenuItemIngredientDAO iFoodbeverageIngredientDatabase) {
        HashMap<String, Integer> r = new HashMap<String, Integer>();

        for(List<String> list : foodIngredient){
            if(list.get(1).equals(foodBeverageid)){
                r.put(list.get(0) ,Integer.parseInt(list.get(2)));
            }
        }
        if(r.isEmpty()){
            r.put("0",0);
            return r;
        }
        return r;
    }

    @Override
    public HashMap<IIngredients, Integer> fetchNameQuantity(String foodBeverageid, MenuItemIngredientDAO iFoodbeverageIngredientDatabase) {
        HashMap<IIngredients, Integer> r = new HashMap<IIngredients, Integer>();
        IIngredients ingredients =Kitchen.Instance().kitchenFactory.MakeIngredient();

        for(List<String> list : foodIngredient){
            if(list.get(1).equals(foodBeverageid)){
                ingredients.setId(list.get(0));
                r.put(ingredients ,Integer.parseInt(list.get(2)));
            }
        }

        if(r.isEmpty()){
            ingredients.setId("0");
            r.put(ingredients,0);
            return r;
        }
        return r;
    }

    public void addFoodIngredient(){
      foodIngredient  = Arrays.asList( Arrays.asList("1", "A", "10"), Arrays.asList("2", "B", "20"), Arrays.asList("3", "C", "30"));
    }
}
