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
		assertEquals(bookService.createBook("A word with power", "Over under", "Killer Time", "Lane 49494","./resources/booksTest"),
				"Book was created");
	}

	//@Test
	public void bookAuthorWasCreated() {
		BookService bookService = new BookService();
		assertEquals(bookService.createBook("A word with power", "The ONE", "Test Pub", "Test Add","./resources/booksTest"),
				"Book was created");
	}

}
