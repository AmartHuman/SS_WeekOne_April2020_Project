package com.ss.test.book;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ss.service.BookService;

public class UpdateBookTest {

	@Test
	public void bookWasUpdated() {
		BookService bookService = new BookService();
		bookService.loadFiles();
		assertEquals(bookService.updateBook("A Test", "Test was Good","./resources/booksTest"),
				"Book has been updated");
	}
	
	@Test
	public void bookNameIsNull() {
		BookService bookService = new BookService();
		bookService.loadFiles();
		assertEquals(bookService.updateBook(null, "Test was Good","./resources/booksTest"),"Names cannot be null");
	}
	
	
	@Test
	public void bookAllWhereIsNull() {
		BookService bookService = new BookService();
		bookService.loadFiles();
		assertEquals(bookService.updateBook(null, null,"./resources/booksTest"),"Names cannot be null");
	}

}
