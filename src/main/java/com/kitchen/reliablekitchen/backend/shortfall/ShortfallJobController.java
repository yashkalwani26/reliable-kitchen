package com.kitchen.reliablekitchen.backend.shortfall;

import com.kitchen.reliablekitchen.backend.ingredients.IngredientDAO;
import com.kitchen.reliablekitchen.backend.ingredients.IngredientsDatabase;
import com.kitchen.reliablekitchen.backend.kitchenfactory.Kitchen;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ShortfallJobController {

  @Scheduled(cron = "1 8 * * * *")
  public void initiate() {
    IShortfallOrder shortfallOrder= Kitchen.Instance().kitchenFactory.MakeShortFallOrder();
    IngredientDAO ingredientDAO = new IngredientsDatabase();
    ShortfallOrderDAO sDao = new ShortfallOrderDatabase();
    ShortfallOrderItemDAO sItemDAO = new ShortfallOrderItemDatabase();
    shortfallOrder.initiateOrderToRetailer(ingredientDAO, sDao, sItemDAO);
  }
}
