package com.vomtung.controller;

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
		User user=new User();
		user.setSolved(false);
		model.addAttribute("user", user);
		return "index";
	}
	
	@RequestMapping(value="/submit",method=RequestMethod.POST)
	String submit(	@ModelAttribute(value = "user")User user,
			ModelMap model,
			BindingResult bindingResult){
		
		UserValidator userValidator = new UserValidator();
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			return "index";
		} else {
			user.setResult("user.Solved:"+user.getSolved());
			model.addAttribute("user", user);
			return "index";
		}
	}
}
