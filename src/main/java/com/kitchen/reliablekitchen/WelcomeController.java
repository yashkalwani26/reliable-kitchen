package com.kitchen.reliablekitchen;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

    @RequestMapping(value = "/welcome")
    public ModelAndView welcome()
    {
        ModelAndView MV=new ModelAndView("Welcome");
        return MV;
    }
}
