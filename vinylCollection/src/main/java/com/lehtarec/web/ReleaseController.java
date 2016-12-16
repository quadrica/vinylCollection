package com.lehtarec.web;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.lehtarec.domain.Release;
import com.lehtarec.domain.ReleaseForm;


import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by PENGUIN on 21.11.2016.
 */
@Controller
public class ReleaseController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    
    
    
    //login to app
    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }
    
    //show list of all releases
    @RequestMapping(value="/releaselist")
    public String releaseList(Model model) {
        // Fetch all releases
        List<Map<String, Object>> releases = jdbcTemplate.queryForList("select id, title, artist, imgurl from VC_Release");


        // Add releaselist to model and return to view
        model.addAttribute("releases", releases);
        return "releaselist";

    }
    
    //delete release from collection #admin role only
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteRelease(@PathVariable("id") Long releaseId, Model model) {
        
        String deleteQuery = "DELETE FROM VC_Release WHERE id=?";
        Long idd = releaseId;
        
    	jdbcTemplate.update(deleteQuery, idd);

    	return "redirect:../releaselist";
    
    }    
    
    //add release to collection
    @RequestMapping(value = "addrelease")
    public String addUser(Model model) {
        model.addAttribute("releaseform", new ReleaseForm());
        return "addrelease";
    }
    
    //save release
    @RequestMapping(value = "saverelease", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("releaseform") ReleaseForm releaseForm, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) { // validation errors
                String title = releaseForm.getTitle();
                String artist = releaseForm.getArtist();
                String imgurl = releaseForm.getImgurl();
                

                Release newRelease = new Release();
                newRelease.setTitle(releaseForm.getTitle());
                newRelease.setArtist(releaseForm.getArtist());
                newRelease.setImgurl(releaseForm.getImgurl());

                //TODO check if the release exists
                jdbcTemplate.update("insert into VC_Release(title, artist, imgurl) values (?, ?, ?)", title, artist, imgurl);
                System.out.println("release added");
        }
        else {
            return "addrelease";
        }
        return "redirect:/releaselist";
    }
    
    //RESTful service to get release by id
    //TODO possibility to add file instead of image url
    @RequestMapping(value = "/release/rest/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Release restOne(@PathVariable("id") Long id) {
        String query = "SELECT title, artist, imgurl" +
                " from VC_Release where id = " + id;
 
        return (Release) jdbcTemplate.queryForObject(query, (resultSet, i) -> {
            Release releaseout = new Release();
            releaseout.setId(id);
            releaseout.setTitle(resultSet.getString(1));
            releaseout.setArtist(resultSet.getString(2));
            releaseout.setImgurl(resultSet.getString(3));
            return releaseout;
        });
    }
    
  //RESTful service to get all releases
    @RequestMapping(value = "/release/rest/all")
    public
    @ResponseBody
    List<Release> restAll() {
    	String queryAll = "SELECT * from VC_Release";
        List<Release> releases = new ArrayList<Release>();
        releases =  jdbcTemplate.query(queryAll, new RowMapper<Release>(){
        	        	
        	@Override
        	public Release mapRow(ResultSet rs, int rowNumber) throws SQLException {
        		Release releaseout = new Release();
        		//releaseout.setRowNumber(rowNumber);
        		releaseout.setId(rs.getLong("id"));
        		releaseout.setTitle(rs.getString("title"));
        		releaseout.setArtist(rs.getString("artist"));
        		releaseout.setImgurl(rs.getString("imgurl"));
        		return releaseout;
        	}
        });
    	return releases;
    }
}