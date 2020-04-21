/**
 * 
 */
package com.ss.test.author;



import org.junit.Test;

import com.ss.dao.AuthorDao;

/**
 * @author Alfred
 *
 */
public class WriteAuthorTest {
	
	@Test(expected = NullPointerException.class)
	public void wirteFilePathIsNull() {
		AuthorDao authorDao = new AuthorDao();
		authorDao.writeAuthorFile(null);
	}
	
	
	@Test
	public void writeFilePathFound() {
		AuthorDao authorDao = new AuthorDao();
		String path = "./resources/authorsTest";
		authorDao.writeAuthorFile(path);
	}
	
	

}
