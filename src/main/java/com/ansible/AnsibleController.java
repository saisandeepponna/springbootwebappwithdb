package com.ansible;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/")
public class AnsibleController {

	@Autowired
	private UserRepo userRepo;
	

	/*
	 * @GetMapping("/") public String homePage() {
	 * 
	 * return "hello"; }
	 */
	@GetMapping("/")
	public ModelAndView homePage() {
	 ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("hello");
	    return modelAndView;
	}
		/*
		 * @GetMapping("/register") public String registerForm(Model model) {
		 * model.addAttribute("registration", new Registration()); return
		 * "registration"; }
		 */

		/*
		 * @PostMapping("/register") public String registerSubmit(@ModelAttribute
		 * Registration registration, Model model) { model.addAttribute("registration",
		 * registration); return "return"; }
		 */
	  
	  @GetMapping("/register")
		public ModelAndView addUserForm() {
			ModelAndView mav = new ModelAndView("registration");
			Registration newRegistration = new Registration();
			mav.addObject("registration", newRegistration);
			return mav;
		}
	  
		/*
		 * @PostMapping("/register") public String saveUser(@ModelAttribute Registration
		 * registration) { userRepo.save(registration); return "return"; }
		 */
	  
	  @PostMapping("/return")
	  public ModelAndView RegisterSuccess(Registration registeredUser) {
		    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		    String encodedPassword = passwordEncoder.encode(registeredUser.getPass());
		    registeredUser.setPass(encodedPassword);
		     
		    userRepo.save(registeredUser);
		    
		    ModelAndView modelAndView = new ModelAndView();
		    modelAndView.setViewName("return");
		    return modelAndView;
	      
		     
		   
		}
	  
	  @GetMapping("/users")
	  public ModelAndView listUsers(Model model) {
	      List<Registration> listUsers = userRepo.findAll();
	      model.addAttribute("listUsers", listUsers);
	      ModelAndView modelAndView = new ModelAndView();
		    modelAndView.setViewName("users");
		    return modelAndView;
	      
	  }
	

	  
	  
}
