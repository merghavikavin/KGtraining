package com.springxml.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.annotation.Validated;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        System.out.println("Home Page Requested, locale = " + locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "home";
    }

    @RequestMapping("/")
    public String showPage() {
        return "home";  //.jsp file without extension
    }

     @RequestMapping("/helloworld")
    public String hello(ModelMap map) {
       
        String helloWorldMessage = "Helloworld!";
        String welcomeMessage = "Welcome!";
        map.addAttribute("helloMessage", helloWorldMessage); //("variable name", object)
        map.addAttribute("welcomeMessage", welcomeMessage);
        return "home";
       
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String user(@Validated User user, Model model) {
        System.out.println("User Page Requested");
        model.addAttribute("userName", user.getUserName());
        return "user"; //.jsp file without extension
    }

}