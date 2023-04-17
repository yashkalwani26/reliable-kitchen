package com.kitchen.reliablekitchen.backend.shortfall;

import com.kitchen.reliablekitchen.backend.kitchenfactory.Kitchen;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShortfallOrderDatabaseMock implements ShortfallOrderDAO {

  List<IShortfallOrder> shortfallOrders = new ArrayList<>();

  public ShortfallOrderDatabaseMock() {
    for (int i = 0; i < 5; i++) {
      addShortfallOrderToMock(i);
    }
  }

  void addShortfallOrderToMock(int i) {
    IShortfallOrder sOrder = Kitchen
      .Instance()
      .kitchenFactory.MakeShortFallOrder();
    sOrder.setRetailerOrderId("SO" + i + 1);
    sOrder.setOrderTimestamp(new Date().toString());
    shortfallOrders.add(sOrder);
  }

  @Override
  public boolean insertRetailerOrder(IShortfallOrder shortfallOrder) {
    shortfallOrders.add(shortfallOrder);
    return true;
  }

  @Override
  public List<IShortfallOrder> findAll() {
    return shortfallOrders;
  }
}
