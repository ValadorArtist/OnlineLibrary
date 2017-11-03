package spring.mvc.library.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.mvc.library.data.BookLending;
import spring.mvc.library.data.books;
import spring.mvc.library.data.users;
import spring.mvc.library.services.BookLendingService;
import spring.mvc.library.services.bookService;
import spring.mvc.library.services.userService;

@Controller
public class bookLendingController {

	@Autowired
	private BookLendingService bLService;
	
	@Autowired
	private userService userService;
	
	@Autowired
	private bookService bookService;
	
	
	
	@GetMapping("/bookInfo")
	public String bookInfo(@RequestParam("bookId") int bookId, Model model, HttpServletRequest request){
		
		boolean isAccess = false;
		HttpSession session = request.getSession();
		String login = (String) session.getAttribute("login");
		books Book = bookService.getBookById(bookId);
		
		List<users> Users = userService.getAccessUsers(login);
		
		for(users User: Users){
			if( User.getLibraryUser().equals(Book.getOwner()) || Book.getIsActualReading().equals(login)){
				isAccess = true;
				model.addAttribute("mode", "modeOne");
				break;
			}
		}
	
		model.addAttribute("book", Book);
		model.addAttribute("login", login);
		
		if(Book.getOwner().equals(login)){
			model.addAttribute("lendParam", new BookLending());
		}else if(isAccess == false){
			model.addAttribute("mode", "modeNoAccess");
			model.addAttribute("lendParam", new BookLending());
		}
	
		return "bookInfo";
	}
	
	@PostMapping("/bookInfo/lendBook")
	public String lendBook( @Valid @ModelAttribute("lendParam") BookLending LBook, 
							BindingResult theResult,HttpServletRequest request, Model model){
		
		if(theResult.hasErrors()){
			model.addAttribute("mode", "ErrorOne");
			model.addAttribute("bookId", LBook.getId());
			return "ErrorInfo";
		
		}
		
		return "MainPage";
	}
}
