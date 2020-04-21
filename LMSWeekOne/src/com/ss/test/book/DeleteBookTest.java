package com.ss.test.book;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


import com.ss.service.BookService;

public class DeleteBookTest {
	
	//@Test
	public void deleteABook() {
		BookService bookService = new BookService();
		bookService.loadFiles();
		assertEquals(bookService.deleteBook("Testing Book","./resources/booksTest"), "The Book Was removed from the database");
	}
	
	@Test
	public void bookNameIsNullOrEmpty() {
		BookService bookService = new BookService();
		bookService.loadFiles();
		assertEquals(bookService.deleteBook(null,"./resources/booksTest"), "Book Name cannot be null!");
	}
	
	@Test
	public void bookNameIsWasNotFound() {
		BookService bookService = new BookService();
		bookService.loadFiles();
		assertEquals(bookService.deleteBook("asd","./resources/booksTest"), "No Book by that name was found");
	}
	


}
