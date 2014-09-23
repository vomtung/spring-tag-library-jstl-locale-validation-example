package com.vomtung.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vomtung.entity.User;

@Controller
@RequestMapping(value="/index")
public class IndexController {
	
	@RequestMapping(method=RequestMethod.GET)
	String index(ModelMap model){
		
		initData(model);
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
		initData(model);
		model.addAttribute("user", user);
		if (bindingResult.hasErrors()) {
			return "index";
		} else {
			user.setResult("skills:"+user.getSkills().toString()+";username:"+user.getUsername()+
					";Relation status:"+user.getRelationshipStatus()+
					";Color eyes:"+user.getColorEyes()
					);
			return "index";
		}
	};
	
	void initData(ModelMap model){
		Map<String,String>countryList=new HashMap<String, String>();
		countryList.put("us", "United State");
		countryList.put("ge", "German");
		countryList.put("vn", "VietNam");
		countryList.put("jp", "Japan");
		model.addAttribute("countryList", countryList);
		
		Map<String,String>skillList=new HashMap<String,String>();
		skillList.put("java","Java");
		skillList.put("c","C");
		skillList.put("php","PHP");
		skillList.put("javascript","JavaScript");
		skillList.put("ruby","Ruby");
		model.addAttribute("skillList",skillList);
		
		Map<String,String>sexList=new HashMap<String, String>();
		sexList.put("M", "Male");
		sexList.put("F", "Female");
		model.addAttribute("sexList", sexList);
		
		Map<String,String>relationshipStatusList=new HashMap<String, String>();
		relationshipStatusList.put("S", "Single");
		relationshipStatusList.put("M", "Married");
		relationshipStatusList.put("D", "Divorce");
		relationshipStatusList.put("U", "Unkown");
		model.addAttribute("relationshipStatusList", relationshipStatusList);
		
		Map<String,String>colorEyesList=new HashMap<String, String>();
		colorEyesList.put("B","Blue");
		colorEyesList.put("G","Green");
		colorEyesList.put("Br","Brown");
		colorEyesList.put("Bl","Black");
		model.addAttribute("colorEyesList", colorEyesList);
		
	}
}
