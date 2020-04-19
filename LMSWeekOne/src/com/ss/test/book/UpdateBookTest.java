package com.ss.test.book;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ss.service.BookService;

public class UpdateBookTest {

	@Test
	public void bookWasUpdated() {
		BookService bookService = new BookService();
		bookService.loadFiles();
		assertEquals(bookService.updateBook("A Test", "Test was Good", "NO CHANGE", "NO CHANGE"),
				"Book has been updated");
	}
	
	@Test
	public void bookNameIsNull() {
		BookService bookService = new BookService();
		bookService.loadFiles();
		assertEquals(bookService.updateBook(null, "Test was Good", "NO CHANGE", "NO CHANGE"),"Names cannot be null");
	}
	
	@Test
	public void bookNewNameIsNull() {
		
	}
	@Test
	public void bookAuthorNameIsNull() {
		
	}
	@Test
	public void bookPublisherNameIsNull() {
		
	}
	@Test
	public void bookAllWhereIsNull() {
		BookService bookService = new BookService();
		bookService.loadFiles();
		assertEquals(bookService.updateBook(null, null, null, null),"Names cannot be null");
	}

}
