package com.rest.onlinebookstore.service;

import java.util.Set;

import com.rest.onlinebookstore.entity.Book;
import com.rest.onlinebookstore.entity.Customer;

public interface BookUserService {

	Set<Book> getBooksPurchasedBy(Customer customer);

}
