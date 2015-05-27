package com.footballwc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(value="/group/add",method = RequestMethod.GET)
    public String printTeamForm(ModelMap model) {

        model.addAttribute("message", "group adding");
        return "add_group";

    }
    @RequestMapping(value="/group/add",method = RequestMethod.POST)
    public String addGroup(@RequestParam("group") String group, ModelMap model) {
        System.out.println("Вот она страна моей мечты"+group);
        model.addAttribute("group", group);
        return "added_group";

    } 
    @RequestMapping(value="/bob",method = RequestMethod.GET)
    public String printWelcomeBob(ModelMap model) {

        model.addAttribute("message", "BoB");
        return "added_group";

    }
    
}