package com.footballwc.controller;

import com.footballwc.entity.Fgroup;
import com.footballwc.entity.Team;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import com.footballwc.service.Factory;
import java.sql.SQLException;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.eclipse.persistence.annotations.FetchGroup;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping( method = RequestMethod.GET)
    public ModelAndView forwardAdmin() throws SQLException {
        ModelAndView modelAndView = new ModelAndView("admin");
        return modelAndView;
    }

    
    @RequestMapping( method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request) throws SQLException {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/groups");
        HttpSession session = request.getSession();
        if (request.getParameter("login").equals("admin") && request.getParameter("password").equals("admin")) {
           session.setAttribute("authorized", "true");
        }
        return modelAndView;
    }
    
        @RequestMapping( value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        session.removeAttribute("authorized");
        return "redirect:../";
    }

    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    public String printGroups(ModelMap model) throws SQLException {
        model.addObject("groups", Factory.getInstance().getFGroupDAO().getAll());
        model.addAttribute("message", "List of Groups");
        return "groups";

    }

    @RequestMapping(value = "/group/{groupId}", method = RequestMethod.GET)
    public String printTeamForm(ModelMap model, @PathVariable int groupId) throws SQLException {
        Fgroup fgroup = Factory.getInstance().getFGroupDAO().getById(groupId);
        model.addObject("group", fgroup);

        Collection<Team> teams = fgroup.getTeamCollection();
        model.addObject("teams", teams);

        model.addAttribute("groupSize", teams.size());
        model.addAttribute("message", "Добавление команды в группу");
        return "group";

    }

    @RequestMapping(value = "/group/del", method = RequestMethod.POST)
    public String DeleteTeam(ModelMap model, @RequestParam("team_to_del") int teamId) throws SQLException {
        Team team = Factory.getInstance().getTeamDAO().getById(teamId);
        Fgroup group = team.getIdGroup();
        Factory.getInstance().getTeamDAO().delete(team);

        return "redirect:" + group.getIdGroup();

    }

    @RequestMapping(value = "/team/add", method = RequestMethod.POST)
    public String addGroup(@RequestParam("groupId") int groupId, @RequestParam("country") String country, ModelMap model) throws SQLException {
        Fgroup group = Factory.getInstance().getFGroupDAO().getById(groupId);
        Team team = new Team();
        team.setCountry(country);

        team.setIdGroup(group);
        Factory.getInstance().getTeamDAO().add(team);
        return "redirect:../group/" + groupId;

    }

    @RequestMapping(value = "/group/{groupId}/create_matches", method = RequestMethod.GET)
    public String createGroupMatches(ModelMap model, @PathVariable int groupId) throws SQLException {

        model.addObject("groups", Factory.getInstance().getFGroupDAO().getAll());
        model.addAttribute("message", "List of Groups");
        return "redirect:/";

    }

    @RequestMapping(value = "/bob", method = RequestMethod.GET)
    public ModelAndView printWelcomeBob() {

        ModelAndView model = new ModelAndView();
        model.addObject("message", "BoB");
        model.setViewName("team_add");
        return model;

    }

}
