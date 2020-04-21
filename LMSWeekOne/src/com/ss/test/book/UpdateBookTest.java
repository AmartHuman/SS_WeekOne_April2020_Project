package com.ss.test.book;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ss.service.BookService;

public class UpdateBookTest {

	//@Test
	public void bookWasUpdated() {
		BookService bookService = new BookService();
		bookService.loadFiles();
		assertEquals(bookService.updateBook("Testing Book", "Test was Good", "./resources/booksTest"),
				"Book has been updated");
	}

	@Test
	public void bookNameIsNull() {
		BookService bookService = new BookService();
		bookService.loadFiles();
		assertEquals(bookService.updateBook(null, "Test was Good", "./resources/booksTest"), "Names cannot be null");
	}

	@Test
	public void bookAllWhereIsNull() {
		BookService bookService = new BookService();
		bookService.loadFiles();
		assertEquals(bookService.updateBook(null, null, "./resources/booksTest"), "Names cannot be null");
	}

	@Test
	public void bookWasNotFoundInDatabase() {
		BookService bookService = new BookService();
		bookService.loadFiles();
		assertEquals(bookService.updateBook("AAAAA", "Not found", "./resources/booksTest"),
				"The Book was not found in the database");
	}

	@Test
	public void bookNameIsToShort() {
		BookService bookService = new BookService();
		bookService.loadFiles();
		assertEquals(bookService.updateBook("Testing Book", "A", "./resources/booksTest"),
				"The Books New Name is less then 3 characters or is longer then 45 characters");
	}

	@Test
	public void bookNameIsToLong() {
		BookService bookService = new BookService();
		bookService.loadFiles();
		assertEquals(bookService.updateBook(
				"Testing Book",
				"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "./resources/booksTest"),
				"The Books New Name is less then 3 characters or is longer then 45 characters");
	}

}
