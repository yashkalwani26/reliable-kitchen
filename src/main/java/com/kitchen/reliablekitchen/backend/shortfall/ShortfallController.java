package com.kitchen.reliablekitchen.backend.shortfall;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kitchen.reliablekitchen.backend.kitchenfactory.Kitchen;

@Controller
public class ShortfallController {

  @RequestMapping("/shortfallOrders")
  public ModelAndView allShortfallOrders() {
    ModelAndView model = new ModelAndView("shortfall/shortfallOrders");
    IShortfallOrder shortfallOrder = Kitchen.Instance().kitchenFactory.MakeShortFallOrder();
    ShortfallOrderDAO sDao = new ShortfallOrderDatabase();
    model.addObject("shortfallOrders", shortfallOrder.getAllShortfallOrders(sDao));
    return model;
  }

  @RequestMapping(
    value = "/fetchShortFallOrderList",
    method = RequestMethod.POST
  )
  public ModelAndView fetchShortFallOrderList(
    @RequestParam String shortfallOrderId
  ) {
    ModelAndView model = new ModelAndView("shortfall/shortfallOrderList");
    IShortfallOrderItem shortfallOrderItem = Kitchen.Instance().kitchenFactory.MakeShortFallOrderItem();
    shortfallOrderItem.setRetailerOrderId(shortfallOrderId);
    ShortfallOrderItemDAO sItemDAO = new ShortfallOrderItemDatabase();
    model.addObject(
      "shortfallOrdersList",
      shortfallOrderItem.getAllShortfallOrderItems(sItemDAO)
    );
    return model;
  }
}
