package spring.mvc.library.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

import spring.mvc.library.classes.Email;
import spring.mvc.library.data.books;
import spring.mvc.library.data.users;
import spring.mvc.library.services.userService;
import spring.mvc.library.services.bookService;

@Controller
public class loginController{
	
	@Autowired
	private userService userService;
	@Autowired
	private bookService bookService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, editor);
	}
	
	@PostMapping("/login")
	public String main(@Valid @ModelAttribute("user") users User, BindingResult theResult ,Model theModel,
						HttpServletRequest request){
		
		if(theResult.hasErrors()){
			return "main";
		}else
		{	
			String check = userService.checkUser(User);
			
			if(check.contentEquals("true")){
				
				HttpSession session = request.getSession();
				session.setAttribute("login", User.getLogin());
				session.setAttribute("libraryUser", User.getLogin());
				
				List<books> Books = bookService.getBooks(User.getLogin());
				List<users> libraryNameList = userService.getAccessUsers(User.getLogin());
				
				
				theModel.addAttribute("libraryNameList", libraryNameList);
				theModel.addAttribute("booksList", Books);
				theModel.addAttribute("invite", new users());
				
				return "MainPage";
			}else{
				return "main";
			}
			
		}
	}
	
	@GetMapping("/MainPage")
	public String MainPage(Model theModel, HttpServletRequest request){
		
		HttpSession session = request.getSession();	
		String login = (String) session.getAttribute("login");
		String libraryUser = request.getParameter("library");
		
		if(libraryUser.equals("all")){
			List<books> Books = bookService.getAllBooks();
			List<users> libraryNameList = userService.getAccessUsers(login);
			
			theModel.addAttribute("libraryNameList", libraryNameList);
			theModel.addAttribute("booksList", Books);
			
			theModel.addAttribute("invite", new users());
			return "MainPage";
		}else{
			
			session.setAttribute("libraryUser", libraryUser);

			List<books> Books = bookService.getBooks(libraryUser);
			for(books Book: Books){
				System.out.println(Book.getId()+"\n");
			}
			List<users> libraryNameList = userService.getAccessUsers(login);
			
			theModel.addAttribute("libraryNameList", libraryNameList);
			theModel.addAttribute("booksList", Books);
			
			theModel.addAttribute("invite", new users());
			return "MainPage";
		}		
		
	}
	@RequestMapping("/Invite")
	public String invite(@Valid @ModelAttribute("invite") users User, BindingResult theResult ,Model theModel,
							HttpServletRequest request){
		
		if(theResult.hasErrors()){
			return "MainPage";
		}else
		{	
			HttpSession session = request.getSession();
			String login = (String)session.getAttribute("login");
			session.setAttribute("libraryUser", login);
			
			new Email(User.getEmail(), User.getLogin(), User.getPassword());
			
			List<books> Books = bookService.getBooks(login);
			List<users> libraryNameList = userService.getAccessUsers(login);
			
			theModel.addAttribute("libraryNameList", libraryNameList);
			theModel.addAttribute("booksList", Books);
			theModel.addAttribute("login", login);
			theModel.addAttribute("libraryUser", login);
			theModel.addAttribute("invite", new users());
			return "MainPage";
		}
		
	}
	
	@GetMapping("/inviteValid")
	public String inviteValid(HttpServletRequest request, Model theModel){
			
			String from = request.getParameter("who");
			String to = request.getParameter("to");
			try{
				users User = userService.getUser(to);
				User.setLibraryUser(from);
				User.setPassword("null");
				userService.addUser(User);
			}catch(NullPointerException nrp){
				theModel.addAttribute("user",new users());
				return "main";
			}
	
			theModel.addAttribute("user", new users());
			return "main";
	}
}
