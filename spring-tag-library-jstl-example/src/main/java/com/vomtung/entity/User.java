package com.vomtung.entity;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class User {
	
	private List<String> favouriteSkill;
	
	String result;
	
	String label;
	
	List<String>skills;
	
	String country;
	
	@NotNull
	@Size(min=5,max=10)
	String username;
	
	@NotNull
	@Size(min=5,max=10)
	String password;
	
	String sex;
	
	String relationshipStatus;
	
	List<String> colorEyes;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<String> getFavouriteSkill() {
		return favouriteSkill;
	}

	public void setFavouriteSkill(List<String> favouriteSkill) {
		this.favouriteSkill = favouriteSkill;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRelationshipStatus() {
		return relationshipStatus;
	}

	public void setRelationshipStatus(String relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}

	public List<String> getColorEyes() {
		return colorEyes;
	}

	public void setColorEyes(List<String> colorEyes) {
		this.colorEyes = colorEyes;
	}

	
	
}
