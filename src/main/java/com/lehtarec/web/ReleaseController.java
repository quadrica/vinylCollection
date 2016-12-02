package com.lehtarec.web;

import java.util.List;
import java.util.Map;

import com.lehtarec.domain.Release;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by PENGUIN on 21.11.2016.
 */
@Controller
public class ReleaseController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value="/releaselist")
    public String releaseList(Model model) {
        // Fetch all releases
        List<Map<String, Object>> releases = jdbcTemplate.queryForList("select title, artist from VC_Release");


        // Add releaselist to model and return to view
        model.addAttribute("releases", releases);
        return "releaselist";

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteRelease(@PathVariable("releaseId") long releaseId, Model model) {
        System.out.println(model.toString());
        jdbcTemplate.update("delete from VC_Release where releaseId=?", releaseId);
        return "redirect:../releaselist";
    }
}

