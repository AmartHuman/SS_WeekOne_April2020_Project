/**
 * 
 */
package com.ss.test.author;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ss.service.AuthorService;

/**
 * @author Alfred
 *
 */
public class DeleteAuthorTest {

	@Test
	public void authorNameIsNullOrEmpty() {
		AuthorService authorService = new AuthorService();
		assertEquals(authorService.deleteAuthor(null, "./resources/authorsTest"), "Name Cannot be null!");
	}

	@Test
	public void authorFilePathIsNullOrEmpty() {
		AuthorService authorService = new AuthorService();
		assertEquals(authorService.deleteAuthor("Mario Red", null), "Path cannot be null!");
	}

	@Test
	public void authorNameWasNotFound() {
		AuthorService authorService = new AuthorService();
		assertEquals(authorService.deleteAuthor("T", "./resources/authorsTest"), "No Author by that name was found");
	}

	@Test
	public void authorWasRemoved() {
		AuthorService authorService = new AuthorService();
		authorService.loadFiles();
		assertEquals(authorService.deleteAuthor("Mario Red", "./resources/authorsTest"),
				"Author was removed from the database");
	}

}
