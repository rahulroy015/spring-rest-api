package com.rest.onlinebookstore.controller;

import java.util.Set;

import com.rest.onlinebookstore.entity.Book;
import com.rest.onlinebookstore.entity.CurrentSession;
import com.rest.onlinebookstore.entity.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rest.onlinebookstore.entity.Customer;
import com.rest.onlinebookstore.service.BookService;
import com.rest.onlinebookstore.service.ShoppingCartService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService theBookService;

	@Autowired
	ShoppingCartService theCartService;

	@Autowired
  CurrentSession currentSession;

	@GetMapping({"","/"})
	public String viewBooks(Model theModel) {
		//load the books
		Set<Book> books = theBookService.getAllBooks();
		theModel.addAttribute("books", books);

		Customer customer = currentSession.getUser().getCustomer();

		//load shoppingitems
		Set<ShoppingCart> shoppingItems = theCartService.getByUsername(customer);

		theModel.addAttribute("shoppingItems", shoppingItems);
		return "customer-books-list";
	}

}
