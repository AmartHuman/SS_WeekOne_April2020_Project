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

public class CreateAuthorTest {

	@Test
	public void authorNameEmptyOrNull() {
		AuthorService authorService = new AuthorService();
		assertEquals(authorService.createAuthor(null, "./resources/authorsTest"), "Author Name cannot be null");
	}

	@Test
	public void authorFilePathIsNull() {
		AuthorService authorService = new AuthorService();
		assertEquals(authorService.createAuthor("Test Author", null), "File path cannot be null");
	}

	@Test
	public void authorNameIsToShort() {
		AuthorService authorService = new AuthorService();
		assertEquals(authorService.createAuthor("T", "./resources/authorsTest"),
				"The Authors Name is less then 3 characters or is longer then 45 characters");
	}

	@Test
	public void authorNameIsToLong() {
		AuthorService authorService = new AuthorService();
		assertEquals(
				authorService.createAuthor("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT",
						"./resources/authorsTest"),
				"The Authors Name is less then 3 characters or is longer then 45 characters");
	}
	
	@Test
	public void authorIsAlreadyInDatabase() {
		AuthorService authorService = new AuthorService();
		assertEquals(authorService.createAuthor("Mario Red", "./resources/authorsTest"), "Author Exist in the database");
	}
	
	@Test
	public void authorWasCreated() {
		AuthorService authorService = new AuthorService();
		assertEquals(authorService.createAuthor("Test Author", "./resources/authorsTest"), "Name was created");
	}
	

}
