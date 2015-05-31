package com.footballwc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import com.footballwc.service.Factory;
import java.sql.SQLException;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @RequestMapping(value="/groups",method = RequestMethod.GET)
    public String printGroups(ModelMap model) throws SQLException {
        model.addObject("groups",Factory.getInstance().getFGroupDAO().getAll());
        model.addAttribute("message", "List of Groups");
        return "groups";

    }

    @RequestMapping(value="/team/add/{groupId}",method = RequestMethod.GET)
    public String printTeamForm(ModelMap model,@PathVariable int groupId) throws SQLException {
        model.addObject("group",Factory.getInstance().getFGroupDAO().getById(groupId));
        model.addAttribute("message", "Team adding to group");
        return "team_add";

    }
    @RequestMapping(value="/team/add",method = RequestMethod.POST)
    public String addGroup(@RequestParam("groupId") int groupId,@RequestParam("country") String country, ModelMap model) {
        model.addAttribute("country", country);
        model.addAttribute("groupId", groupId);
        return "team_added";

    } 
    @RequestMapping(value="/bob",method = RequestMethod.GET)
    public ModelAndView printWelcomeBob() {
    
        ModelAndView model = new ModelAndView();
        model.addObject("message", "BoB");
        model.setViewName("team_add");
        return model;

    }
    
}