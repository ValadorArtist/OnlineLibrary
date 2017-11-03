package spring.mvc.library.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.library.services.userService;
import spring.mvc.library.classes.Email;
import spring.mvc.library.data.users;

@Controller
public class addUserController {
	
		@Autowired
		private userService userService;
		
		@InitBinder
		public void initBinder(WebDataBinder dataBinder){
			
			StringTrimmerEditor editor = new StringTrimmerEditor(true);
			dataBinder.registerCustomEditor(String.class, editor);
		}
		
		@RequestMapping("/addUser")
		public String addUser(Model theModel){
			
			theModel.addAttribute("add_user", new users());
			return "addUser";
		}
		
		@PostMapping("/addUser_confirm")
		public String addUser(HttpServletResponse response,@Valid @ModelAttribute("add_user") users User, 
							  BindingResult theResult){
			
			if(theResult.hasErrors()){
				return "addUser";
			}else{
				
				Cookie cookie = new Cookie("access", User.getLogin());
				cookie.setMaxAge(60*60*24);
				response.addCookie(cookie);
				
				new Email(User.getEmail(), User.getLogin());
				User.setLibraryUser(User.getLogin());
				userService.addUser(User);
				
				return "addUser_confirm";
			}
		}
		
		@GetMapping("/validation")
		public String validation(Model theModel, HttpServletRequest request, HttpServletResponse response){
			
			String name = request.getParameter("id");
			System.out.println(name);
			
			Cookie[] cookies = request.getCookies();
			
			if (cookies != null) {
				
				 for (Cookie cookie : cookies) {
				   if (cookie.getName().equals("access")) {
					   
					   if(cookie.getValue().equals(name)){
						   
						   userService.activateUser(name);
						   cookie.setMaxAge(0);
			               response.addCookie(cookie);
			               theModel.addAttribute("user", new users());
							return "validation";
					   }
					   else{
							theModel.addAttribute("user", new users());
							return "main";
					   }
					   
				    }else{
						theModel.addAttribute("user", new users());
						return "main";
					}
				 }
				 
					 
			}else{
				theModel.addAttribute("user", new users());
				return "main";
			}
				
			return "null";
		 }
	
}
