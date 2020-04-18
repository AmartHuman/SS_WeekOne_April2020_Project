/**
 * 
 */
package com.ss.test.author;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


import com.ss.service.AuthorService;

/**
 * @author Alfred
 *
 */

public class CreateAuthorTest {
	
	@Test
	public void authorNameEmptyOrNull() {
		AuthorService authorService = new AuthorService();
		try {
			assertEquals(authorService.createAuthor(null), "Author Name cannot be null");
		} catch (IOException e) {
			System.out.println("File not found");
		}
	}
	
	
	public void authorDuplicateIDFound() {
		
	}

}
