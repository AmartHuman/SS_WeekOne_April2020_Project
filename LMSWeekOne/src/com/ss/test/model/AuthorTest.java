/**
 * 
 */
package com.ss.test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ss.model.Author;

/**
 * @author Alfred
 *
 */
public class AuthorTest {

	@Test
	public void authorGetId() {
		Author author = new Author(123, "Name of");
		assertEquals(123, author.getAuthorId(), 123);
	}

	@Test
	public void authorGetName() {
		Author author = new Author(123, "Name of");
		assertEquals("Name of", author.getAuthorName(), "Name of");
	}

	@Test
	public void setAuthorId() {
		Author author = new Author(123, "Name of");
		author.setAuthorId(234);
		assertEquals(234, author.getAuthorId(), 234);
	}

	@Test
	public void setAuthorName() {
		Author author = new Author(123, "Name of");
		author.setAuthorName("Set Name");
		;
		assertEquals("Set Name", author.getAuthorName(), "Set Name");
	}

	@Test
	public void testEqualsSymmetric() {
		Author author = new Author(123, "Name of");
		Author authorTwo = new Author(123, "Name of");
		assertTrue(author.equals(authorTwo) && authorTwo.equals(author));
		assertTrue(author.hashCode() == authorTwo.hashCode());
	}

	@Test
	public void testDoesNotEqualsSymmetric() {
		Author author = new Author(123, "Name of");
		Author authorTwo = new Author(1233, "Not name of");
		assertFalse(author.equals(authorTwo) && authorTwo.equals(author));
		assertFalse(author.hashCode() == authorTwo.hashCode());
	}

	@Test
	public void testNullInHashCode() {
		Author author = new Author(null, null);
		Author authorTwo = new Author(1233, "Not name of");
		assertFalse(author.equals(authorTwo) && authorTwo.equals(author));
		assertFalse(author.hashCode() == authorTwo.hashCode());
	}

}
