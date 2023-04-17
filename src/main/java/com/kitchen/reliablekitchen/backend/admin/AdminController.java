package com.kitchen.reliablekitchen.backend.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
    @RequestMapping(value="/welcome",method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password)
    {
        ModelAndView model;
        Admin a=new Admin();
        a.setUsername(username);
        a.setPassword(password);
        IAuthentication auth=new AdminDB();
        if (a.login(auth).isLoggedIN()==true )
        {
            model=new ModelAndView("/Welcome");
        }
        else {
            model = new ModelAndView("/adminlogin/login");
        }
        return model;
    }
    @RequestMapping("/")
    public ModelAndView home()
    {
        ModelAndView modelAndView = new ModelAndView("/adminlogin/login");
        return modelAndView;
    }
}
