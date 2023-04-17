package com.kitchen.reliablekitchen.backend.shortfall;

import java.util.ArrayList;
import java.util.List;

import com.kitchen.reliablekitchen.backend.kitchenfactory.Kitchen;

public class ShortfallOrderItemDatabaseMock implements ShortfallOrderItemDAO{

    List<IShortfallOrderItem> shortfallOrderItems = new ArrayList<>();

    public ShortfallOrderItemDatabaseMock(){
        for(int i =0; i<5; i++){
            addShortfallOrderItemToMock("SOID1","ING"+i,"INGName"+i, i+1);
        }
    }

    void addShortfallOrderItemToMock(String sOrderId, String ingredientId, String ingredientName, int quantity ){
        IShortfallOrderItem sOrderItem = Kitchen.Instance().kitchenFactory.MakeShortFallOrderItem();
        sOrderItem.setRetailerOrderId(sOrderId);
        sOrderItem.setIngredientId(ingredientId);
        sOrderItem.setIngredientName(ingredientName);
        sOrderItem.setShortfallQuantity(quantity);
        shortfallOrderItems.add(sOrderItem);
    }

    @Override
    public boolean insertRetailerOrderList(IShortfallOrderItem shortfallOrderlist) {
        shortfallOrderItems.add(shortfallOrderlist);
        return true;
    }

    @Override
    public List<IShortfallOrderItem> findAllById(IShortfallOrderItem shortfallOrderList) {
        return shortfallOrderItems;
    }

}
