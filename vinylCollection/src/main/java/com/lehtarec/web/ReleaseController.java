package com.lehtarec.web;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.lehtarec.domain.Release;

import com.lehtarec.domain.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


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
        List<Map<String, Object>> releases = jdbcTemplate.queryForList("select id, title, artist, imgurl from VC_Release");


        // Add releaselist to model and return to view
        model.addAttribute("releases", releases);
        return "releaselist";

    }
    
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteRelease(@PathVariable("id") Long releaseId, Model model) {
        
        String deleteQuery = "DELETE FROM VC_Release WHERE id=?";
        Long idd = releaseId;
        
    	jdbcTemplate.update(deleteQuery, idd);

    	return "redirect:../releaselist";
    
    }    
    
    
    
}


