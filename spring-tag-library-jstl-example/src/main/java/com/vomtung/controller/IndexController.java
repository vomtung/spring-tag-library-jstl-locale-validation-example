package com.vomtung.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vomtung.entity.User;

@Controller
@RequestMapping(value="/index")
public class IndexController {
	
	@RequestMapping(method=RequestMethod.GET)
	String index(ModelMap model){
		
		List<String>countryList=new ArrayList<String>();
		countryList.add("vietnam");
		countryList.add("us");
		countryList.add("us");
		
		Map<String,String>sexList=new HashMap<String,String>();
		sexList.put("male","Male");
		sexList.put("female","Female");
		
		Map<String,String>skillList=new HashMap<String,String>();
		skillList.put("java","Java");
		skillList.put("c","C");
		skillList.put("php","PHP");
		skillList.put("javascript","JavaScript");
		skillList.put("ruby","Ruby");
		model.put("skillList",skillList);
		
		User user=new User();
		user.setLabel("label example");
		List<String>skills=new ArrayList<String>();
		skills.add("java");
		skills.add("c");
		user.setSkills(skills);
		List<String>favouriteSkills=new ArrayList<String>();
		favouriteSkills.add("php");
		favouriteSkills.add("javascript");
		user.setFavouriteSkill(favouriteSkills);
		model.addAttribute("user", user);
		
		return "index";
	};
	
	@RequestMapping(value="/submit",method=RequestMethod.POST)
	String submit(@Valid @ModelAttribute(value = "user") User user,
			BindingResult bindingResult,
			ModelMap model){
		UserValidator userValidator = new UserValidator();
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			Map<String,String>skillList=new HashMap<String,String>();
			skillList.put("java","Java");
			skillList.put("c","C");
			skillList.put("php","PHP");
			skillList.put("javascript","JavaScript");
			skillList.put("ruby","Ruby");
			model.put("skillList",skillList);
			return "index";
		} else {
			Map<String,String>skillList=new HashMap<String,String>();
			skillList.put("java","Java");
			skillList.put("c","C");
			skillList.put("php","PHP");
			skillList.put("javascript","JavaScript");
			skillList.put("ruby","Ruby");
			model.put("skillList",skillList);
			model.addAttribute("user", user);
			user.setResult("skills:"+user.getSkills().toString()+";username:"+user.getUsername());
			return "index";
		}
	};
}
