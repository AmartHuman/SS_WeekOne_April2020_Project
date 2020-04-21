package com.ss.test.author;



import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ss.service.AuthorService;

public class ReadAuthorTest {
	
	@Test
	public void authorsAreBeingReadFrom() {
		AuthorService authorService = new AuthorService();
		authorService.loadFiles();
		assertEquals(authorService.readAuthor(),"done");
	}

}
