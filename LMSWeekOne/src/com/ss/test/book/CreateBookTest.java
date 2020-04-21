/**
 * 
 */
package com.ss.test.book;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ss.service.BookService;

/**
 * @author Alfred
 *
 */
public class CreateBookTest {

	@Test
	public void bookWasCreated() {
		BookService bookService = new BookService();
		assertEquals(bookService.createBook("A word with power", "Over under", "Killer Time", "Lane 49494",
				"./resources/booksTest"), "Book was created");
	}
	
	//@Test
	public void bookIsAlreadyInDatabase() {
		BookService bookService = new BookService();
		bookService.loadFiles();
		assertEquals(bookService.createBook("Testing Book", "Over under", "Killer Time", "Lane 49494",
				"./resources/booksTest"), "There is a book with a Name as the one entered in the database");
	}

	@Test
	public void bookAuthorWasCreated() {
		BookService bookService = new BookService();
		assertEquals(bookService.createBook("A word with power", "Not Real Auhtor", "Test Pub", "Test Add",
				"./resources/booksTest"), "Book was created");
	}

	@Test
	public void bookPublisherWasCreated() {
		BookService bookService = new BookService();
		assertEquals(bookService.createBook("A word with power", "The ONE", "Not A pub", "Test Add",
				"./resources/booksTest"), "Book was created");
	}

	@Test
	public void bookNameIsToShort() {
		BookService bookService = new BookService();
		assertEquals(bookService.createBook("A", "Over under", "Killer Time", "Lane 49494", "./resources/booksTest"),
				"The Books Name is less then 3 characters or is longer then 45 characters");
	}

	@Test
	public void bookNameIsToLong() {
		BookService bookService = new BookService();
		assertEquals(bookService.createBook(
				"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",
				"Over under", "Killer Time", "Lane 49494", "./resources/booksTest"),
				"The Books Name is less then 3 characters or is longer then 45 characters");
	}

	@Test
	public void bookAuhtorNameIsToShort() {
		BookService bookService = new BookService();
		assertEquals(bookService.createBook("A word with power", "A", "Not A pub", "Test Add", "./resources/booksTest"),
				"The Authors Name is less then 3 characters or is longer then 45 characters");
	}

	@Test
	public void bookAuhtorNameIsToLong() {
		BookService bookService = new BookService();
		assertEquals(bookService.createBook("A word with power",
				"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",
				"Not A pub", "Test Add", "./resources/booksTest"),
				"The Authors Name is less then 3 characters or is longer then 45 characters");
	}

	@Test
	public void bookPublisherIsToShort() {
		BookService bookService = new BookService();
		assertEquals(
				bookService.createBook("A word with power", "Killer time", "A", "Test Add", "./resources/booksTest"),
				"The Publishers Name is less then 3 characters or is longer then 45 characters");
	}

	@Test
	public void bookPublisherIsToLong() {
		BookService bookService = new BookService();
		assertEquals(bookService.createBook("A word with power", "Killer time",
				"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",
				"Test Add", "./resources/booksTest"),
				"The Publishers Name is less then 3 characters or is longer then 45 characters");
	}

	@Test
	public void bookPublisherAddressIsToShort() {
		BookService bookService = new BookService();
		assertEquals(
				bookService.createBook("A word with power", "Killer time", "A new pub", "T", "./resources/booksTest"),
				"The Publishers Address is less then 3 characters or is longer then 45 characters");
	}

	@Test
	public void bookPublisherAddressIsToLong() {
		BookService bookService = new BookService();
		assertEquals(bookService.createBook("A word with power", "Killer time", "A new pub",
				"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",
				"./resources/booksTest"),
				"The Publishers Address is less then 3 characters or is longer then 45 characters");
	}

}
