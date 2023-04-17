package com.kitchen.reliablekitchen.backend.shortfall;

import java.util.List;

public interface ShortfallOrderDAO {

    public boolean insertRetailerOrder(IShortfallOrder shortfallOrder);

      public List<IShortfallOrder> findAll();
}
