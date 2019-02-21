package com.cg.app.ProfileServicWebpage.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.cg.app.ProfileServicWebpage.Entity.Profile;

@Controller
public class ProfileWebpageResource {

	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/")
	public String depositForm()
	{
		return "index";	
		
	}
	@RequestMapping("/signUp")
	public String signUp() {
		return "signUpForm";
	}
	
	@RequestMapping("/signUpMethod")
	public String signupForm(@ModelAttribute Profile profile,Model model) {
		restTemplate.postForEntity("http://localhost:3251/profiless/",profile,null);
		model.addAttribute("message","Success!");
		return "signUp";
		
	}
	
//	@RequestMapping("/signIn")
//	public String signIn() {
//		return "signInForm";
//	}
//	@RequestMapping("/signUpMethod")
//	public void getAllAccounts(@ModelAttribute Profile profile,Model model) {
//		restTemplate.getForEntity("http://localhost:3251/profiless/",Profile.class);
//		model.addAttribute("message","Success!");
//		//return "signUp";

	
	
	@RequestMapping("/getAccount")
	public void getAccount(@ModelAttribute Profile profile,Model model) {
		restTemplate.getForEntity("http://localhost:3251/profiless/profileId",Profile.class);
		//model.addAttribute("message","Success!");
		//return "signUp";

	}
	
//	@RequestMapping("/signinMethod")
//	public String signinForm(@ModelAttribute Profile profile,Model model) {
//		//restTemplate.postForEntity("http://localhost:3251/profiless/profileId/phoneNumber",profile,null);
//		restTemplate.getForEntity("http://localhost:3251/profiless/profileId/phoneNumber",profile);
//	
//		model.addAttribute("message","Success!");
//		return null;
//		
//	}
//
//	
}
