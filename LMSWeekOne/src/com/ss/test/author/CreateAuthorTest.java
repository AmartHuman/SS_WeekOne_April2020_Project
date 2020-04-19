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
		assertEquals(authorService.createAuthor(null), "Author Name cannot be null");
	}
	
	
	public void authorDuplicateIDFound() {
		
	}

}
