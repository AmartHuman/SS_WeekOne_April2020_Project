/**
 * 
 */
package com.ss.test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ss.model.Author;
import com.ss.model.Book;
import com.ss.model.Publisher;

/**
 * @author Alfred
 *
 */
public class BookTest {
	
	@Test
	public void authorGetId() {
		Author author = new Author(123, "AuthorName");
		Publisher publisher = new Publisher(123,"Publisher Name","Publisher Address");
		Book book = new Book(123, "Name of",author,publisher);
		assertEquals(123, book.getBookId(), 123);
	}

	@Test
	public void authorGetName() {
		Author author = new Author(123, "AuthorName");
		Publisher publisher = new Publisher(123,"Publisher Name","Publisher Address");
		Book book = new Book(123, "Name of",author,publisher);
		assertEquals("Name of", book.getBookName(), "Name of");
	}

	@Test
	public void setAuthorId() {
		Author author = new Author(123, "AuthorName");
		Publisher publisher = new Publisher(123,"Publisher Name","Publisher Address");
		Book book = new Book(123, "Name of",author,publisher);
		book.setBookId(234);;
		assertEquals(234, book.getBookId(), 234);
	}

	@Test
	public void setAuthorName() {
		Author author = new Author(123, "AuthorName");
		Publisher publisher = new Publisher(123,"Publisher Name","Publisher Address");
		Book book = new Book(123, "Name of",author,publisher);
		book.setBookName("Set Name");
		;
		assertEquals("Set Name", book.getBookName(), "Set Name");
	}

	@Test
	public void testEqualsSymmetric() {
		Author author = new Author(123, "AuthorName");
		Publisher publisher = new Publisher(123,"Publisher Name","Publisher Address");
		Book book = new Book(123, "Name of",author,publisher);
		Book bookTwo = new Book(123, "Name of", author, publisher);
		assertTrue(book.equals(bookTwo) && bookTwo.equals(book));
		assertTrue(book.hashCode() == bookTwo.hashCode());
	}

	//@Test
	public void testDoesNotEqualsSymmetric() {
		Author author = new Author(123, "AuthorName");
		Publisher publisher = new Publisher(123,"Publisher Name","Publisher Address");
		Book book = new Book(123, "Name of",author,publisher);
		Book bookTwo = new Book(123, "Name of", author, publisher);
		assertFalse(book.equals(bookTwo) && bookTwo.equals(book));
		assertFalse(book.hashCode() == bookTwo.hashCode());
	}

	//@Test
	public void testNullInHashCode() {
		Author author = new Author(123, "AuthorName");
		Publisher publisher = new Publisher(123,"Publisher Name","Publisher Address");
		Book book = new Book(123, "Name of",author,publisher);
		Book bookTwo = new Book(123, "Name of", author, publisher);
		assertFalse(book.equals(bookTwo) && bookTwo.equals(book));
		assertFalse(book.hashCode() == bookTwo.hashCode());
	}

}
