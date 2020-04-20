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
public class UpdateAuthorTest {

	@Test
	public void authorNameWasUpdated() {
		AuthorService authorService = new AuthorService();
		authorService.loadFiles();
		assertEquals(authorService.updateAuthor("Huamn Man", "AAAAA Author", "./resources/authorsTest"),
				"Author Has been updated");
	}

	@Test
	public void authorNameIsNullOrEmpty() {
		AuthorService authorService = new AuthorService();
		assertEquals(authorService.updateAuthor(null, "Test Author", "./resources/authorsTest"),
				"Name Cannot be null!");
	}

	@Test
	public void authorNewNameIsNullOrEmpty() {
		AuthorService authorService = new AuthorService();
		assertEquals(authorService.updateAuthor("Test Author", null, "./resources/authorsTest"),
				"Name Cannot be null!");
	}

	@Test
	public void authorBothNamesAreNullOrEmpty() {
		AuthorService authorService = new AuthorService();
		assertEquals(authorService.updateAuthor(null, null, "./resources/authorsTest"), "Name Cannot be null!");
	}

	@Test
	public void authorNameNotFound() {
		AuthorService authorService = new AuthorService();
		assertEquals(authorService.updateAuthor("T", "Test Author", "./resources/authorsTest"),
				"There is no author by that name to update");
	}

	@Test
	public void authorNewNameIsToShort() {
		AuthorService authorService = new AuthorService();
		assertEquals(authorService.updateAuthor("Mario Red", "T", "./resources/authorsTest"),
				"The Authors New Name is less then 3 characters or is longer then 45 characters");
	}

	@Test
	public void authorNewNameIsToLong() {
		AuthorService authorService = new AuthorService();
		assertEquals(
				authorService.updateAuthor("Mario Red", "TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT",
						"./resources/authorsTest"),
				"The Authors New Name is less then 3 characters or is longer then 45 characters");
	}

}
