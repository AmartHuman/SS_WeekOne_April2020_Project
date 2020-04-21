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
public class ReadBookTest {
	
	@Test
	public void booksAreBeingReadFrom() {
		BookService bookService = new BookService();
		bookService.loadFiles();
		assertEquals(bookService.readBook(),"done");
	}

}
