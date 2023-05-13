package com.rest.onlinebookstore.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import com.rest.onlinebookstore.dao.BookRepository;
import com.rest.onlinebookstore.dao.BookUserRepository;
import com.rest.onlinebookstore.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.onlinebookstore.entity.Customer;

@Service
public class BookUserServiceImpl implements BookUserService {

	@Autowired
	private BookUserRepository bookUserRepos;

	@Autowired
	private BookRepository bookRepos;

	@Override
	@Transactional
	public Set<Book> getBooksPurchasedBy(Customer customer) {

		Set<Integer> bookIds = bookUserRepos.getPurchasedBooks(customer.getUsername());

		Set<Book> books = new HashSet<Book>();

		for(int id : bookIds) {
			Optional<Book> obj = bookRepos.findById(id);
			if(obj.isPresent()) {
				books.add(obj.get());
			}
		}
		customer.setBooks(books);

		return books;
	}

}
