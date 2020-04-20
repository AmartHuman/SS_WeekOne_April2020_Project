/**
 * 
 */
package com.ss.test.book;

import org.junit.Test;

import com.ss.dao.BookDao;

/**
 * @author Alfred
 *
 */
public class WriteBookTest {
	
	@Test(expected = NullPointerException.class)
	public void wirteFilePathIsNull() {
		BookDao bookDao = new BookDao();
		bookDao.wirteBookFile(null);
	}
	
	
	@Test
	public void writeFilePathFound() {
		BookDao bookDao = new BookDao();
		String path = "./resources/authorsTest";
		bookDao.wirteBookFile(path);
	}

}
