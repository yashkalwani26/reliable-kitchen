package com.kitchen.reliablekitchen.backend.shortfall;

import java.util.List;

public interface ShortfallOrderItemDAO {
  public boolean insertRetailerOrderList(IShortfallOrderItem shortfallOrderlist);

  public List<IShortfallOrderItem> findAllById(
    IShortfallOrderItem shortfallOrderList
  );
}
