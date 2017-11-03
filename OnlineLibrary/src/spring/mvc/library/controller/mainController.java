package spring.mvc.library.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.library.data.users;


@Controller
public class mainController {
	
	@RequestMapping("/")
	public String mainLogin(Model theModel){
		
		theModel.addAttribute("user",new users());
		return "main";
	}
	
	@PostMapping("/main")
	public String mainLogin2(Model theModel, HttpServletRequest request){
		
		HttpSession sesja = request.getSession();
		sesja.removeAttribute("login");
		theModel.addAttribute("user",new users());
		return "main";
	}
	
	
}
