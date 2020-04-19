package com.ss.test.book;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ss.service.BookService;

public class DeleteBookTest {
	
	//@Test
	public void deleteABook() {
		BookService bookService = new BookService();
		bookService.loadFiles();
		assertEquals(bookService.deleteBook("A Test",0,0), "The Book Was removed from the database");
	}
	
	//@Test
	public void bookNameIsNullOrEmpty() {
		BookService bookService = new BookService();
		bookService.loadFiles();
		assertEquals(bookService.deleteBook(null,0,0), "Book Name cannot be null!");
	}
	
	//@Test
	public void bookNameIsWasNotFound() {
		BookService bookService = new BookService();
		bookService.loadFiles();
		assertEquals(bookService.deleteBook("asd",0,0), "No Book by that name was found");
	}
	
	//@Test
	public void bookOfAuthorsWereRemoved() {
		BookService bookService = new BookService();
		bookService.loadFiles();
		assertEquals(bookService.deleteBook("NO BOOK",1,0), "Books of that Author were removed as well");
	}
	
	@Test
	public void bookOfPublisherWereRemoved() {
		BookService bookService = new BookService();
		bookService.loadFiles();
		assertEquals(bookService.deleteBook("NO BOOK",0,2), "Books of that Publisher were removed as well");
	}


}
