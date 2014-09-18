package com.vomtung.controller;

import java.util.regex.Pattern;

import org.springframework.validation.*;

import com.vomtung.entity.User;

public class UserValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		return User.class.equals(arg0);
	}

	public void validate(Object obj, Errors error) {

		User user = (User) obj;
		if (error.hasFieldErrors("age"))
			error.rejectValue("age", "age.valid");
		/*if (acc.getAge() > 120 || acc.getAge() < 1)
			error.rejectValue("age", "age.invalid");
		if (!EmailValidate(acc.getEmail()))
			error.rejectValue("email", "email.invalid");*/
		if (user.getUsername().length() < 4){
			error.rejectValue("username", "username.too_short");
		}
	}

	private boolean EmailValidate(String hex) {
		Pattern pattern = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		return pattern.matcher(hex).matches();
	}

}
