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
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.mvc.library.services.bookService;
import spring.mvc.library.classes.Url;
import spring.mvc.library.data.books;
import spring.mvc.library.data.users;
import spring.mvc.library.services.userService;

@Controller
public class addBookController {

	@Autowired
	private userService userService;
	
	@Autowired
	private bookService bookService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, editor);
	}
	
	
	@RequestMapping("/addBookManual")
	public String addBookManual(Model theModel, HttpServletRequest request){
		
		HttpSession session = request.getSession();
		String data= (String)session.getAttribute("libraryUser");
		theModel.addAttribute("libraryUser", data);
		theModel.addAttribute("book", new books());
		
		return "addBookManual";
	}
	
	
	@RequestMapping("/addBookByParsing")
	public String addBookByParsing(Model theModel, HttpServletRequest request){

		theModel.addAttribute("url", new Url());		
		return "addUrl";
	}
	
	@PostMapping("/addBookValid")
	public String addBookBPValid(@Valid @ModelAttribute("url") Url url, BindingResult theResult ,Model theModel,
								 HttpServletRequest request){
		
		if(theResult.hasErrors()){
			return "addUrl";
		}else{
			books Book = new books();
			Book.setTitle( url.getTitle());
			Book.setAuthor( url.getAutor());
			Book.setPages( url.getPages());
			Book.setPublishingHouse("Helion");
			
			HttpSession session = request.getSession();
			String data= (String)session.getAttribute("libraryUser");
			theModel.addAttribute("libraryUser", data);
			theModel.addAttribute("book", Book);
			return "addBookManual";
		}
	}
	
	@PostMapping("/addBook_confirm")
	public String abConfirm(@Valid @ModelAttribute("book") books Book, BindingResult theResult ,Model theModel,
							HttpServletRequest request){
		
		if(theResult.hasErrors()){
			return "addBookManual";
		}else
		{	
			bookService.addBook(Book);
			
			HttpSession session = request.getSession();
			String login = (String)session.getAttribute("login");
			session.setAttribute("libraryUser", login);
			
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
}
