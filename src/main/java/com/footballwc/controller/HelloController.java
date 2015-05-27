package com.footballwc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/team")
public class HelloController {

    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String printTeamForm(ModelMap model) {

        model.addAttribute("message", "Spring 3 MVC - Hello World");
        return "add_team";

    }
    @RequestMapping(value="/add",method = RequestMethod.POST)
    public String addTeam(@RequestParam("country") String country,ModelMap model) {
        System.out.println("Вот она страна моей мечты"+country);
        model.addAttribute("country", country);
        return "added_team";

    } 
    @RequestMapping(value="/bob",method = RequestMethod.GET)
    public String printWelcomeBob(ModelMap model) {

        model.addAttribute("message", "BoB");
        return "hello";

    }
    
}