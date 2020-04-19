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

	//@Test
	public void bookWasCreated() {
		BookService bookService = new BookService();
		assertEquals(bookService.createBook("A word with power", "Super", "over man long", "Lane 49494"),
				"Book was created");
	}

	@Test
	public void bookAuthorWasCreated() {
		BookService bookService = new BookService();
		assertEquals(bookService.createBook("A word with power", "The ONE", "Test Pub", "Test Add"),
				"Book was created");
	}

}
